package lt.is.helpdesk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Is used to enable WebSocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // We register websocket endpoint that clients will user to connect
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // SockJS is used to enable fallback options for browsers that dont support websockets
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
