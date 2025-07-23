package summer_prac.edu_web.controller;

import summer_prac.edu_web.dto.StudentAnswerDto;
import summer_prac.edu_web.dto.TestDto;
import summer_prac.edu_web.entity.Test;
import summer_prac.edu_web.entity.User;
import summer_prac.edu_web.repository.TestRepository;
import summer_prac.edu_web.repository.UserRepository;
import summer_prac.edu_web.service.TestService;
import summer_prac.edu_web.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    private final TestRepository testRepository;
    private final UserService userService;

    @GetMapping("/tests")
    public String allTests(@AuthenticationPrincipal UserDetails userDetails, ModelMap modelMap){
        List<Test> tests = testRepository.findAll();
        modelMap.addAttribute("tests", tests);
        User user = userService.getByEmail(userDetails.getUsername());
        modelMap.addAttribute("user", user);
        return "all-tests";
    }

    @GetMapping("/new-test")
    public String newTest(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.getByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("testDto", new TestDto());
        return "new-test";
    }

    @PostMapping("/new-test")
    public String newTest(@ModelAttribute("testDto")@Valid TestDto testDto,
                          BindingResult result, Model model) {
        if (testDto == null) {
            result.rejectValue("testName", null, "Test Name is required");
        }
        if (result.hasErrors()) {
            return "new-test";
        }

        testService.createNewTest(testDto);
        System.out.println(testRepository.findAll());
        Long currentTestId = testRepository.findByName(testDto.getTestName()).getId();
        return "redirect:/new-test/"+currentTestId+"/new-question";
    }
}