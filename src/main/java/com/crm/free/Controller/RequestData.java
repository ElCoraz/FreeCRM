package com.crm.free.Controller;

import java.util.Arrays;
import java.util.HashMap;

import jakarta.servlet.http.HttpServletRequest;

public class RequestData {

	public String[] path;
	public HashMap<String, String> parametrs;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public RequestData(HttpServletRequest request) {

		this.path = request.getRequestURI().split("/");
		this.path = Arrays.copyOfRange(this.path, 1, this.path.length);

		String[] query = request.getQueryString().split("&");

		this.parametrs = new HashMap();

		for(int i = 0; i < query.length; i++) {
			String[] parametr = query[i].split("=");

			this.parametrs.put(parametr[0], parametr[1]);
		}
    }
    
}
