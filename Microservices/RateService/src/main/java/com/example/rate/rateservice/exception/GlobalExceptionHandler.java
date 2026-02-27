package com.example.rate.rateservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.rate.rateservice.entity.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ApiResponse> getResourceNotFoundException(ResourceNotFoundException ex) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMsg("Rating is not found ..!!");
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		apiResponse.setSuccess(false);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
