package com.jwt.springboot3andss6.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jwt.springboot3andss6.model.UserInfo;
import com.jwt.springboot3andss6.repository.UserRepository;

@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserInfo userInfo = userRepository.getByUserName(username);
		
		if(userInfo == null) {
			 logger.error("Username not found: {}", username);
			 throw new UsernameNotFoundException("could not found user..!!");
		}
		logger.info("User Authenticated Successfully..!!!");
		return new CustomUserDetails(userInfo);
	}

}
