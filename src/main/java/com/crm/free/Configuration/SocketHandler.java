package com.crm.free.Configuration;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketHandler extends TextWebSocketHandler {

	private Integer A = 1;

	@Override
	public void handleTextMessage(@SuppressWarnings("null") WebSocketSession session, @SuppressWarnings("null") TextMessage textMessage) 
		throws InterruptedException, IOException {

		JSONObject jsonObject = new JSONObject(textMessage.getPayload());

		String value = jsonObject.getString("value");

		if (value.equals("getData")) {
			JSONObject response = new JSONObject();
			response.put("value", "Hi how may we help you?");
			session.sendMessage(new TextMessage(response.toString()));
		} else if (value.equals("getHTML")) {
			JSONObject response = new JSONObject();
			response.put("value", "<h1>HELLO " + A + "</h1>");
			session.sendMessage(new TextMessage(response.toString()));

			A++;
		}
	}

}