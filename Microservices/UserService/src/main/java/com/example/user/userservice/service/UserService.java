package com.example.user.userservice.service;

import java.util.List;

import com.example.user.userservice.entity.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	List<UserDto> getAllUser();

	UserDto getUserById(Long id);

}
