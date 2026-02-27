package com.example.hotel.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> getResourceNotFoundException(ResourceNotFoundException ex) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMsg("Hotel is not Present..!!");
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		apiResponse.setSuccess(false);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
