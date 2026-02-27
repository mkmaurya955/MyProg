package com.example.user.userservice.exception;


public class ResourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourseNotFoundException() {
		super("User Not Found..!!");
	}

	public ResourseNotFoundException(String msg) {
		super(msg);
	}

}
