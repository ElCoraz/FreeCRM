package com.crm.free.Configuration;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.xml.sax.SAXException;

import com.crm.free.XML;

@Component
public class SocketHandler extends TextWebSocketHandler {

	@Override
	public void handleTextMessage(@SuppressWarnings("null") WebSocketSession session, @SuppressWarnings("null") TextMessage textMessage) 
		throws InterruptedException, IOException, IllegalArgumentException, IllegalAccessException, JSONException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, InvocationTargetException, ParserConfigurationException, SAXException {

		JSONObject jsonObject = new JSONObject(textMessage.getPayload());

		String value = jsonObject.getString("value");

		if (value.equals("getData")) {
			JSONObject response = new JSONObject();
			response.put("value", "Hi how may we help you?");
			session.sendMessage(new TextMessage(response.toString()));
		} else if (value.equals("getHTML")) {
			JSONObject response = new JSONObject();
			response.put("value", new XML().get());
			session.sendMessage(new TextMessage(response.toString()));
		}
	}

}