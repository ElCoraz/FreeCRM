package com.crm.free.Controller;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@RequestMapping(value = "/getName", 
	produces = MediaType.APPLICATION_JSON_VALUE, 
	method = RequestMethod.GET)
	public ResponseEntity<String> getName_GET(HttpServletRequest request) {

		RequestData requestData = new RequestData(request);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("value", "new name1");

		return ResponseEntity.ok(jsonObject.toString());
	}

	@RequestMapping(value = "/getName", 
	produces = MediaType.APPLICATION_JSON_VALUE, 
	method = RequestMethod.POST)
	public ResponseEntity<String> getName_POST(HttpServletRequest request) {

		RequestData requestData = new RequestData(request);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("value", "new name2");

		return ResponseEntity.ok(jsonObject.toString());
	}

	@RequestMapping(value = "/getName", 
	produces = MediaType.APPLICATION_JSON_VALUE, 
	consumes = MediaType.APPLICATION_JSON_VALUE,
	method = RequestMethod.POST)
	public ResponseEntity<String> getName_POST(@Validated @RequestBody String body, HttpServletRequest request) {
 
		RequestData requestData = new RequestData(request);
	
		JSONObject jsonObject = new JSONObject();

        jsonObject.put("value", "new name3");

		return ResponseEntity.ok(jsonObject.toString());
	}
}