package com.example.saveimagewithbody.util;

import org.springframework.http.HttpStatus;

public class ResponseGatway {
	
	private String message;
	
	private Object data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseGatway(Object data, String message, HttpStatus ok) {
		super();
		this.data = data;
		this.message = message;
	}
	
	

}
