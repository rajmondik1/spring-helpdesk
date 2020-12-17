package lt.is.helpdesk.controller;

import lt.is.helpdesk.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // what is payload?
    // MessageMapping - message with specified route will be routed to those endpoints
    @MessageMapping("/sendMessage/{token}")
    @SendTo("/topic/{token}")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage, @DestinationVariable String token) {
        System.out.println(chatMessage.getSender() + ' ' + chatMessage.getContent());
        return chatMessage;
    }

    // TODO: Impl this later

    @MessageMapping("/chat.connected/{token}")
    @SendTo("/topic/{token}")
    public ChatMessage connected(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor,
            @DestinationVariable String token
    ) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        headerAccessor.getSessionAttributes().put("token", chatMessage.getToken());
        return chatMessage;
    }
}
