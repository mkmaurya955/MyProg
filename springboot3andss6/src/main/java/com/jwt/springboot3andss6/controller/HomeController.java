package com.jwt.springboot3andss6.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.springboot3andss6.model.UserInfo;
import com.jwt.springboot3andss6.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<UserInfo> getUser() {
		
		logger.warn("This is working message");
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/current-user")
	public String getCurrentUser(Principal principal) {
		return "currentUser  : " + principal.getName();
	}
	
	
	@PostMapping("/addUser")
	public String addUsers(@RequestBody UserInfo userInfo) {
		
		return userService.addUser(userInfo);
		
	}
	
	@GetMapping("/user/normal")
	@PreAuthorize("hasAuthority('USER')")
	public List<UserInfo> getNormalUser() {
		
		logger.warn("This is working message");
		
		return userService.getAllUsers();
	}

}
