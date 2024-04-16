package com.crm.free.Configuration;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.crm.free.Components.Loading;

@Component
public class SocketHandler extends TextWebSocketHandler {

	//private Integer A = 1;

	@Override
	public void handleTextMessage(@SuppressWarnings("null") WebSocketSession session, @SuppressWarnings("null") TextMessage textMessage) 
		throws InterruptedException, IOException, IllegalArgumentException, IllegalAccessException, JSONException {

		JSONObject jsonObject = new JSONObject(textMessage.getPayload());

		String value = jsonObject.getString("value");

		if (value.equals("getData")) {
			JSONObject response = new JSONObject();
			response.put("value", "Hi how may we help you?");
			session.sendMessage(new TextMessage(response.toString()));
		} else if (value.equals("getHTML")) {
			Loading loading = new Loading("1", "2", "Wait");

			JSONObject response = new JSONObject();
			response.put("value", loading.toHTML());
			session.sendMessage(new TextMessage(response.toString()));
		}
	}

}