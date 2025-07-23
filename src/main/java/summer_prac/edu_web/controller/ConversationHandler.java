package summer_prac.edu_web.controller;

import summer_prac.edu_web.dto.MessagePayloadDto;
import summer_prac.edu_web.entity.ChatMessage;
import summer_prac.edu_web.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ConversationHandler {

    private final ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessagePayloadDto send(MessagePayloadDto messageDto) {
        // Save to DB
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender(messageDto.getSender());
        chatMessage.setContent(messageDto.getContent());
        chatMessage.setTimestamp(LocalDateTime.now());
        chatMessageRepository.save(chatMessage);

        // Return DTO to broadcast live
        return messageDto;
    }

}