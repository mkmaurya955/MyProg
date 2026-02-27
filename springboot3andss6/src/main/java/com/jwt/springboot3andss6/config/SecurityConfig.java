package com.jwt.springboot3andss6.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.springboot3andss6.security.JWTAuthenticationFilter;
import com.jwt.springboot3andss6.security.JwtAuthenticationEntryPoint;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint point;
	@Autowired
	private JWTAuthenticationFilter filter;
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
			.cors(cors->cors.disable())
			.authorizeHttpRequests(
					auth->auth
					.requestMatchers("/home/addUser").permitAll()	// Bypass authentication for /addUser
					.requestMatchers("/auth/login").permitAll() // Bypass authentication for /auth/login
					.requestMatchers("/home").authenticated() 	// Require authentication for /home
					.anyRequest().authenticated() 				// Require authentication for all other requests
					)
			.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authenticationProvider(authenticationProvider);
		
		// Add the logging filter before JWT filter
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	

}
