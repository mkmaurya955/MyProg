package com.example.user.userservice.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.userservice.entity.User;
import com.example.user.userservice.entity.UserDto;
import com.example.user.userservice.exception.ResourseNotFoundException;
import com.example.user.userservice.repository.UserRepository;
import com.example.user.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		User saved = userRepository.save(user);
		return modelMapper.map(saved, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> findAll = userRepository.findAll();
		return findAll.stream().map(e->modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("User not found with id: " + id));
		return modelMapper.map(user, UserDto.class);
	}

}
