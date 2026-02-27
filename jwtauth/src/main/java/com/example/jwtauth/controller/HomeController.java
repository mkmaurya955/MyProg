package com.example.jwtauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/welcome")
	public String welcome() {
		String text = "This is my Private Page.";
				text+="This page is not allowed without authentication to users";
		return text;
	}
	
	@GetMapping("/getUser")
	public String getUsername() {
		return "This is UserName";
	}
}
