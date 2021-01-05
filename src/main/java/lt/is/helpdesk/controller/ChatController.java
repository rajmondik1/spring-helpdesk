package lt.is.helpdesk.controller;

import lt.is.helpdesk.dto.ChatMessageDTO;
import lt.is.helpdesk.entity.ChatMessage;
import lt.is.helpdesk.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        ChatMessage saved = chatMessageService.save(chatMessage);

        messagingTemplate.convertAndSendToUser(
                saved.getSession().getId().toString(),
                "/messages",
                new ChatMessageDTO(
                        saved.getContent(),
                        saved.getSender(),
                        saved.getDate()
                )
        );
    }

}