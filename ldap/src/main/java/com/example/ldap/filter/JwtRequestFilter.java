package com.example.ldap.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.ldap.principle.PortalUserPrincipal;
import com.example.ldap.service.PortalUserService;
import com.example.ldap.util.Constants;
import com.example.ldap.util.JwtUtils;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

	private static final Logger log = LoggerFactory.getLogger(JwtRequestFilter.class);
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	private final PortalUserService portalUserService;
	
//	@Autowired
//	private PortalUserService portalUserService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {
			Optional<String> token = JwtUtils.getTokenWithoutBearer(request);
			token.ifPresent(t -> verifyAndAuthenticatePortalUser(request, t));
		} catch (Exception e) {
			log.error(Constants.MESSAGE_AUTHENTICATION_FAILED);
		}
		
		filterChain.doFilter(request, response);
	}

	private void verifyAndAuthenticatePortalUser(HttpServletRequest request, String token) {
		if (JwtUtils.verifyToken(token, jwtSecret)) {
			String username = JwtUtils.extractUsername(token, jwtSecret);
			UserDetails principal = portalUserService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
			auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(auth);
		}
	}

	public JwtRequestFilter(String jwtSecret, PortalUserService portalUserService) {
		super();
		this.jwtSecret = jwtSecret;
		this.portalUserService = portalUserService;
	}
	
	
}
