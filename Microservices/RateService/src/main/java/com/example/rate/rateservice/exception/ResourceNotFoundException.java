package com.example.rate.rateservice.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("Rating is not Present..!!");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
