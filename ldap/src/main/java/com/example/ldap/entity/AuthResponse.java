package com.example.ldap.entity;

import java.util.List;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class AuthResponse extends AbstractResponse {
	private static final long serialVersionUID = -5842662313715118663L;

	private String token;
	private String username;
	private List<String> userRoles;
	
}
