package com.jwt.springboot3andss6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
	

	@Bean
	public UserDetailsService userDetailsService() {
		
//		*************InMemory User Authentication************
//		UserDetails userDetails1 = User.builder().username("manish").password(passwordEncoder().encode("password"))
//				.roles("ADMIN").build();
//		UserDetails userDetails2 = User.builder().username("kumar").password(passwordEncoder().encode("password"))
//				.roles("ADMIN").build();
//		UserDetails userDetails3 = User.builder().username("maurya").password(passwordEncoder().encode("password"))
//				.roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
		
//		**********************DATABASE***********************************
		
		return new CustomUserDetailsServiceImpl();
		
	}

	@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;

    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}

}
