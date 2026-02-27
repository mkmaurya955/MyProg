package com.example.swagger3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Swagger3Controller {
	
	@GetMapping("/getTest")
	public String getTesting() {
		return "I am from Swagger3 (OpenAPI)";
	}

}
