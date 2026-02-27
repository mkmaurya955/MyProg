package com.electronic.store.electronicstore.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronic.store.electronicstore.dtos.UserDto;
import com.electronic.store.electronicstore.entities.Users;
import com.electronic.store.electronicstore.repositories.UserRepository;
import com.electronic.store.electronicstore.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto users) {
		Users user = modelMapper.map(users, Users.class);
		Users saveUser = userRepository.save(user);
		return modelMapper.map(saveUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		Users findById = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User is not find in DB..!!"));
		findById.setName(userDto.getName());;
		findById.setEmail(userDto.getEmail());
		findById.setGender(userDto.getGender());
		findById.setAbout(userDto.getAbout());
		Users updatedUser = userRepository.save(findById);
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public List<UserDto> getAll() {
		List<Users> findAllUsers = userRepository.findAll();
		return findAllUsers.stream().map(e->modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto getByUserId(String userId) {
		Users users = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User is not Found in DB..!!"));
		return modelMapper.map(users, UserDto.class);
	}

	@Override
	public UserDto getUserByName(String userName) {
		Users findByName = userRepository.findByName(userName);
		return modelMapper.map(findByName, UserDto.class);
	}

}
