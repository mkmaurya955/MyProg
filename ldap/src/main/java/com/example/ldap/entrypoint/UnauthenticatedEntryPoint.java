package com.example.ldap.entrypoint;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.example.ldap.util.Constants;

@Configuration
public class UnauthenticatedEntryPoint implements AuthenticationEntryPoint {
	private static final Logger log = LoggerFactory.getLogger(UnauthenticatedEntryPoint.class);

	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException e) throws IOException {
		log.info("Access Denied. Unauthenticated access attempt to resource {} from {} Authorization header: {}",
				httpServletRequest.getRequestURI(),
				Optional.ofNullable(httpServletRequest.getHeader(Constants.HEADER_AUTHORIZATION))
						.orElse(httpServletRequest.getRemoteAddr()),
				httpServletRequest.getHeader(Constants.HEADER_AUTHORIZATION));
		httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST,
				"It seems whether you're trying to access a resource without authenticating. Please authenticate first then try again!");
	}
}
