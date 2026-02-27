package com.example.ldap.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortalUser implements Serializable {
	private static final long serialVersionUID = 8257090513210333742L;

	private String username;
	private List<String> grantedAuthorities;

}
