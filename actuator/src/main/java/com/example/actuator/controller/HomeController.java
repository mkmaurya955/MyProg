package com.example.actuator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.actuator.model.ShowValuePropertyFile;

@RestController
public class HomeController {
	
	
	@Value("${myapp.value}")
	private String val;
	@Autowired
	private ShowValuePropertyFile showValuePropertyFile;
	
	@GetMapping("/value")
	public String getvalue() {
		return val;
	}

	@GetMapping("/value/prop")
	public ShowValuePropertyFile getValueProperty() {
		return showValuePropertyFile;
	}
}
