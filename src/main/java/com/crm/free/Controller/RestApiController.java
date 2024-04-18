package com.crm.free.Controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.crm.free.Stack.Code;
import com.crm.free.Stack.Module;
import com.crm.free.Stack.OpCode;
import com.crm.free.Stack.Varible;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class RestApiController {

	/*
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
	*/

	@RequestMapping(value = "/getName", 
	produces = MediaType.APPLICATION_JSON_VALUE, 
	consumes = MediaType.APPLICATION_JSON_VALUE,
	method = RequestMethod.POST)
	public ResponseEntity<String> getName_POST(@Validated @RequestBody String body, HttpServletRequest request) {
 
		//RequestData requestData = new RequestData(request);
	
		JSONObject jsonObjectBody = new JSONObject(body);

		JSONArray opcodes = jsonObjectBody.getJSONArray("opcode");
		JSONArray varibles = jsonObjectBody.getJSONArray("varibles");

		Module module = new Module(varibles.length(), opcodes.length());

		for(int i = 0; i < varibles.length(); i++) {
			JSONObject jsonObject = varibles.getJSONObject(i);

			Varible varible = new Varible();

			varible.name = jsonObject.getString("name");
			varible.type = jsonObject.getString("type");
			varible.value = jsonObject.getInt("value");

			module.varibles[i] = varible;
		}		

		for (int i = 0; i < opcodes.length(); i++) {
			JSONObject jsonObject = opcodes.getJSONObject(i);
			
			int length = 1;

			if (jsonObject.get("operand") instanceof JSONArray) {
				length = jsonObject.getJSONArray("operand").length();
			}
			
			Code code = new Code(length);

			code.line = jsonObject.getInt("line");
			code.code = OpCode.valueOf(jsonObject.getString("cmd"));
			
			if (jsonObject.get("operand") instanceof JSONArray) {
				JSONArray op = jsonObject.getJSONArray("operand");
				for (int j = 0; j < length; j++) {
					code.operands[j] = op.getInt(j);
				}
			} else {
				code.operands[0] = jsonObject.getInt("operand");
			}

			module.opcodes[i] = code;
		}		

		return ResponseEntity.ok("");
	}
}