package com.jwt.springboot3andss6.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.springboot3andss6.model.JwtRequest;
import com.jwt.springboot3andss6.model.JwtResponse;
import com.jwt.springboot3andss6.security.JwtHelper;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest){
		logger.info("*********Token Generation Started************");
		doauthenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
		
		String generateToken = helper.generateToken(userDetails);
		
		 JwtResponse response = JwtResponse.builder()
	                .jwtToken(generateToken)
	                .username(userDetails.getUsername()).build();
		
		 return new ResponseEntity<>(response, HttpStatus.OK);
		
	}


	private void doauthenticate(String email, String password) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authenticationToken);
			
		} catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
	}
	
	@ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
