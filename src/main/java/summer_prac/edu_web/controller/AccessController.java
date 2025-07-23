package summer_prac.edu_web.controller;

import summer_prac.edu_web.dto.SignupFormDto;
import summer_prac.edu_web.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccessController {

    private final UserService accountManager;

    @GetMapping("/register")
    public String displayRegisterPage(Model viewData) {
        viewData.addAttribute("userDto", new SignupFormDto());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute("userDto") @Valid SignupFormDto registrationData,
                                     BindingResult validationResults) {

        if (!registrationData.getPassword().equals(registrationData.getConfirmPassword())) {
            validationResults.rejectValue("confirmPassword", null, "Passwords do not match");
        }

        if (accountManager.emailExists(registrationData.getEmail())) {
            validationResults.rejectValue("email", null, "Email already exists");
        }

        if (validationResults.hasErrors()) {
            return "register";
        }

        accountManager.registerNewUser(registrationData);
        return "redirect:/login";
    }
}