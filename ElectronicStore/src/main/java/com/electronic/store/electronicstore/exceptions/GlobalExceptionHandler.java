package com.electronic.store.electronicstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseMessage> resourceNotFoundException(ResourceNotFoundException ex) {
		ApiResponseMessage response = new ApiResponseMessage();
		response.setMessage(ex.getMessage());
		response.setSuccess(true);
		response.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BadException.class)
	public ResponseEntity<ApiResponseMessage> badRequestExecption(BadException ex){
		ApiResponseMessage response = new ApiResponseMessage();
		response.setMessage(ex.getMessage());
		response.setSuccess(true);
		response.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		
	}

}
