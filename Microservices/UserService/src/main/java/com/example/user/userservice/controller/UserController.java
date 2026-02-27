package com.example.user.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.userservice.entity.UserDto;
import com.example.user.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto user = userService.createUser(userDto);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAll() {
		List<UserDto> allUser = userService.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);

	}

	@GetMapping("/getById")
	public ResponseEntity<UserDto> getuserById(@PathVariable("id") Long id) {
		UserDto userById = userService.getUserById(id);
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}

}
