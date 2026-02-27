package com.jwt.springboot3andss6.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwt.springboot3andss6.model.UserInfo;
import com.jwt.springboot3andss6.model.UserRole;

public class CustomUserDetails extends UserInfo implements UserDetails{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	 private String password;
	 List<GrantedAuthority> authorities;

	 public CustomUserDetails(UserInfo byUsername) {
	        this.userName = byUsername.getUserName();
	        this.password= byUsername.getPassword();
	        List<GrantedAuthority> auths = new ArrayList<>();

	        for(UserRole role : byUsername.getUserRoles()){

	            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
	        }
	        this.authorities = auths;
	    }
	 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
    public String getPassword() {
        return password;
    }

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
