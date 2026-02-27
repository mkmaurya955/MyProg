package com.electronic.store.electronicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electronic.store.electronicstore.dtos.UserDto;
import com.electronic.store.electronicstore.services.UserService;

@RestController
@RequestMapping("/UserDto")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserDto> createUserDto(@RequestBody UserDto UserDto) {
		UserDto createUser = userService.createUser(UserDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<UserDto> updateUserDto(@RequestBody UserDto UserDto, @RequestParam("userId") String userId) {
		UserDto updateUser = userService.updateUser(UserDto, userId);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getAllUserDto() {
		List<UserDto> getAll = userService.getAll();
		return new ResponseEntity<>(getAll, HttpStatus.OK);
	}

	@GetMapping("getById/id")
	public ResponseEntity<UserDto> getByUserId(@PathVariable("userId") String userId) {
		UserDto byUserId = userService.getByUserId(userId);
		return new ResponseEntity<>(byUserId, HttpStatus.OK);
	}

	public ResponseEntity<UserDto> searchByUserName(@RequestParam("userName") String userName) {
		UserDto byUserName = userService.getUserByName(userName);
		return new ResponseEntity<>(byUserName, HttpStatus.OK);

	}

}
