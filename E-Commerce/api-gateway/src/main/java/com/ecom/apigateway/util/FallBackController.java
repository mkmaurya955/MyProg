package com.ecom.apigateway.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@PostMapping("/fallback/product")
	public ResponseEntity<String> fallBackProduct(){
		return ResponseEntity.status(503)
	            .body("Product Service is currently unavailable.Please try again later..!!");
	}
}
