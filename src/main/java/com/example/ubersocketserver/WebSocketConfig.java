package com.example.ubersocketserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker    // Enables STOMP over WebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // Client connects to /ws endpoint
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*") // Allow all origins
                .withSockJS(); //Enable SockJs fallback
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // Messages with /app go to @MessageMapping
        registry.setApplicationDestinationPrefixes("/app");

        // Messages with /topic or /queue are handled by broker
        registry.enableSimpleBroker("/topic" , "/queue");
    }
}
