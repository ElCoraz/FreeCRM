package com.crm.free.Controller;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@RequestMapping(value = "/getName", produces="application/json; charset=UTF-8", method = RequestMethod.GET)
	public String index1() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("value", "new name");

		return jsonObject.toString();
	}

	@RequestMapping(value = "/getName", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public String index2() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("value", "new name");

		return jsonObject.toString();
	}
	

	/*
	@PostMapping("/getName")
	public String index() {
		return "Hello";
	}
	*/
}
