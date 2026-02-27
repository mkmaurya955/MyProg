package com.electronic.store.electronicstore.services;

import java.util.List;

import com.electronic.store.electronicstore.dtos.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, String userId);

	List<UserDto> getAll();

	UserDto getByUserId(String userId);

	UserDto getUserByName(String userName);


}
