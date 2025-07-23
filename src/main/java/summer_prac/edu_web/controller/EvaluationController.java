package summer_prac.edu_web.controller;

import summer_prac.edu_web.entity.StudentAnswer;
import summer_prac.edu_web.entity.Test;
import summer_prac.edu_web.repository.TestRepository;
import summer_prac.edu_web.service.AnswerService;
import summer_prac.edu_web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import summer_prac.edu_web.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EvaluationController {
    private final UserService userService;
    private final TestRepository testRepository;
    private final AnswerService answerService;

    @GetMapping("/tests/{id}/result")
    public String showResult(@AuthenticationPrincipal UserDetails userDetails, Model model, @PathVariable Long id){
        User user = userService.getByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        Optional<Test> test = testRepository.findById(id);
        List<StudentAnswer> answers = answerService.getStudentTestAnswer(test, user);
        model.addAttribute("answers", answers);
        System.out.println(answers.toString());
        return "test_result";

    }

    @GetMapping("/my-results")
    public String showAllMyResults(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.getByEmail(userDetails.getUsername());
        List<StudentAnswer> allAnswers = answerService.getAllStudentAnswers(user);
        model.addAttribute("user", user);
        model.addAttribute("answers", allAnswers);
        return "my_results"; // your freemarker page name
    }


}