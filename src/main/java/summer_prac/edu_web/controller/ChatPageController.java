package summer_prac.edu_web.controller;

import summer_prac.edu_web.entity.ChatMessage;
import summer_prac.edu_web.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatPageController {

    private final ChatMessageRepository chatMessageRepository;

    @GetMapping("/chat")
    public String chatPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("username", userDetails.getUsername());

        List<ChatMessage> messages = chatMessageRepository.findTop50ByOrderByTimestampAsc();
        model.addAttribute("messages", messages);

        return "chat";
    }
}