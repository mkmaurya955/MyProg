package com.example.user.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.user.userservice.common.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourseNotFoundException(ResourseNotFoundException ex) {
		String msg = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMsg(msg);
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		apiResponse.setSuccess(true);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
