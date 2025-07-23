package summer_prac.edu_web.controller;

import summer_prac.edu_web.entity.Questions;
import summer_prac.edu_web.entity.Test;
import summer_prac.edu_web.entity.User;
import summer_prac.edu_web.repository.QuestionRepository;
import summer_prac.edu_web.repository.TestRepository;
import summer_prac.edu_web.service.AnswerService;
import summer_prac.edu_web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TestViewController {

    private final UserService userService;
    private final QuestionRepository questionRepository;
    private final TestRepository testRepository;
    private final AnswerService answerService;

    @GetMapping("/tests/{id}")
    public String solveTest(@AuthenticationPrincipal UserDetails userDetails, Model model, @PathVariable Long id) {
        User user = userService.getByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        List<Questions> questions = questionRepository.questionsByTestId(testRepository.findById(id));
        model.addAttribute("questions", questions);
        model.addAttribute("id", id);
        return "test-id";
    }

    @PostMapping("/tests/{id}")
    public String saveTest(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long id, @RequestParam("ans") List<String> ans){
        User user = userService.getByEmail(userDetails.getUsername());
        Optional<Test> test = testRepository.findById(id);
        List<Questions> questions = questionRepository.questionsByTestId(test);
        answerService.submitAnswer(ans, test, user, questions);
        return "redirect:/";
    }
}