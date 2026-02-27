package com.example.jwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtauth.jwthelper.JwtUtil;
import com.example.jwtauth.model.JwtRequest;
import com.example.jwtauth.model.JwtResponse;
import com.example.jwtauth.services.CustomeUserDetailsService;

@RestController
public class JwtAuthController {
	@Autowired
	private CustomeUserDetailsService customeUserDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/token")
	public ResponseEntity<?> generatToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		System.out.println(jwtRequest);
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		UserDetails userDetails = this.customeUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		
		String generateToken = jwtUtil.generateToken(userDetails);
		
		System.out.println("JWT  --->" + generateToken);
		
		return ResponseEntity.ok(new JwtResponse(generateToken));
	}
	
	
	
}
