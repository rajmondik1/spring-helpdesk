package lt.is.helpdesk.controller;

import lt.is.helpdesk.entity.ChatMessage;
import lt.is.helpdesk.service.WebSocketConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        String token = (String) headerAccessor.getSessionAttributes().get("token");
        if (username != null) {
            logger.info("User disconnected: " + username);

            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setSender(username);
            System.out.println(token);
            System.out.println(WebSocketConnectionService.getInstance().connections.toString());
            WebSocketConnectionService.getInstance().connections.remove(token);

            messageSendingOperations.convertAndSend("/topic/" + token, chatMessage);
        }
    }
}
