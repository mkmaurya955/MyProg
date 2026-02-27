package com.example.ldap.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest implements Serializable {
	
	private static final long serialVersionUID = 2583865165014770858L;
	private String username;
	private String password;
	
}
