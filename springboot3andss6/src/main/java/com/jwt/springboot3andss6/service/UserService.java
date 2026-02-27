package com.jwt.springboot3andss6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.springboot3andss6.model.UserInfo;
import com.jwt.springboot3andss6.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	private List<Users> store = new ArrayList<>();
//
//	public UserService() {
//		super();
//		store.add(new Users(UUID.randomUUID().toString(),"Manish", "manish@gmail.com"));
//		store.add(new Users(UUID.randomUUID().toString(),"Kumar", "kumar@gmail.com"));
//		store.add(new Users(UUID.randomUUID().toString(),"Krishna", "krishna@gmail.com"));
//		store.add(new Users(UUID.randomUUID().toString(),"Radha", "radha@gmail.com"));
//	}

	public List<UserInfo> getAllUsers(){
		return userRepository.findAll();
	}
	 @Transactional
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userRepository.save(userInfo);
		return "Data Added Successfully";
	}
}
