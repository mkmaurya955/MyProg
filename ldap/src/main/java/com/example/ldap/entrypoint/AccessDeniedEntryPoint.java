package com.example.ldap.entrypoint;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.example.ldap.util.Constants;

@Configuration
public class AccessDeniedEntryPoint implements AccessDeniedHandler {

	private static final Logger log = LoggerFactory.getLogger(AccessDeniedEntryPoint.class);

	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AccessDeniedException e) throws IOException {
		log.info("Access Denied. Unauthorized access attempt to resource {} Authorization header: {}",
				httpServletRequest.getRequestURI(), httpServletRequest.getHeader(Constants.HEADER_AUTHORIZATION));

		httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
				"Access Denied. It seems you're trying to access a resource that you are not allowed! ");
	}
}
