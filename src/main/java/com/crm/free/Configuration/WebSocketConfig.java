package com.crm.free.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
  public void registerWebSocketHandlers(@SuppressWarnings("null") WebSocketHandlerRegistry registry) {
		registry.addHandler(new SocketHandler(), "/crm");
	}
}