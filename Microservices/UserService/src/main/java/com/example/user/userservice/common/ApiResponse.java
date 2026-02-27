package com.example.user.userservice.common;

import org.springframework.http.HttpStatus;

public class ApiResponse {

	private HttpStatus status;

	private String msg;

//	private Object data;

	private boolean success;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

//	public Object getData() {
//		return data;
//	}
//
//	public void setData(Object data) {
//		this.data = data;
//	}

}
