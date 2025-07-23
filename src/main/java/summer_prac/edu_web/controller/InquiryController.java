package summer_prac.edu_web.controller;

import summer_prac.edu_web.dto.QuestionDto;
import summer_prac.edu_web.entity.Test;
import summer_prac.edu_web.entity.User;
import summer_prac.edu_web.repository.TestRepository;
import summer_prac.edu_web.service.QuestionService;
import summer_prac.edu_web.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class InquiryController {

    private final QuestionService questionService;
    private final TestRepository testRepository;
    private final UserService userService;

    @GetMapping("new-test/{id}/new-question")
    public String newQuestion(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.getByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("questionDto", new QuestionDto());
        return "new-question";
    }

    @PostMapping("new-test/{id}/new-question")
    public String newQuestion(@ModelAttribute("questionDto")@Valid QuestionDto questionDto,
                              BindingResult result, Model model, @PathVariable Long id) {
        if (questionDto.getOptionA()==null){
            result.rejectValue("optionA",null,"Option A is required");

        }
        if (questionDto.getOptionB()==null){
            result.rejectValue("optionB",null,"Option B is required");

        }
        if (questionDto.getOptionC()==null){
            result.rejectValue("optionC",null,"Option C is required");

        }
        if (questionDto.getCorrectAnswer()==null) {
            result.rejectValue("correctAnswer", null, "Enter The Correct Answer");
        }
        if (result.hasErrors()){
            return "error-screen";
        }
        Optional<Test> test = testRepository.findById(id);

        questionService.createNewQuestion(questionDto, test.orElse(null));
        return "redirect:/new-test/"+id+"/new-question";
    }
}