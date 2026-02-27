package com.example.hotel.hotelservice.exception;


public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("Hotel is not Found..!!");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
