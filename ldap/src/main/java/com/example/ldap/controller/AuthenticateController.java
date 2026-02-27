package com.example.ldap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ldap.entity.AuthRequest;
import com.example.ldap.entity.AuthResponse;
import com.example.ldap.service.PortalUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthenticateController {
	private static final Logger log = LoggerFactory.getLogger(AuthenticateController.class);

	@Autowired
	private PortalUserService portalUserService;

	@PostMapping
	public ResponseEntity<AuthResponse> authenticate(@RequestBody @NonNull AuthRequest authRequest) {
		log.info("Authentication request for user {} received!", authRequest.getUsername());
		return ResponseEntity
				.ok(portalUserService.authenticateUser(authRequest.getUsername(), authRequest.getPassword()));
	}
}
