package summer_prac.edu_web.controller;

import summer_prac.edu_web.entity.User;
import summer_prac.edu_web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final UserService userService;

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails != null) {
            try {
                User user = userService.getByEmail(userDetails.getUsername());
                model.addAttribute("user", user);
            } catch (RuntimeException e) {
                System.out.println("User not found: " + e.getMessage());
            }
        }

        return "main";
    }

    @PostMapping("/")
    public String backHome(){
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails != null) {
            try {
                User user = userService.getByEmail(userDetails.getUsername());
                model.addAttribute("user", user);
            }catch (RuntimeException e) {
                System.out.println("User not found: " + e.getMessage());
            }
        }
        return "admin-dashboard";
    }
}