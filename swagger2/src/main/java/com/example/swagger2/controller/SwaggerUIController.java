package com.example.swagger2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerUIController {
	
	@GetMapping("/testSwagger")
	public String testing() {
		return "I am from swagger2";
	}

}
