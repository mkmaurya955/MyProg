package com.example.ldap.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.ldap.entrypoint.AccessDeniedEntryPoint;
import com.example.ldap.entrypoint.UnauthenticatedEntryPoint;
import com.example.ldap.filter.JwtRequestFilter;
import com.example.ldap.util.Constants;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Autowired
	private UnauthenticatedEntryPoint unauthenticatedEntryPoint;
	@Autowired
	private AccessDeniedEntryPoint accessDeniedEntryPoint;

    @Value("${autz.permitted.paths.all}")
    private String[] permittedPaths;
    @Value("${autz.permitted.paths.finance}")
    private String[] financeRolePermittedPaths;
    @Value("${autz.permitted.paths.business}")
    private String[] businessRolePermittedPaths;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        	http
                .cors()
                .and()
                .csrf()
                    .disable()
                .authorizeRequests()
                .antMatchers(permittedPaths).permitAll()
                .antMatchers(financeRolePermittedPaths).hasAuthority(Constants.LDAP_ROLE_FINANCE)
                .antMatchers(businessRolePermittedPaths).hasAuthority(Constants.LDAP_ROLE_BUSINESS)
                    .anyRequest().authenticated()
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(this.unauthenticatedEntryPoint)
                    .accessDeniedHandler(this.accessDeniedEntryPoint)
                .and()
                    .logout()
                        .disable()
                    .formLogin()
                        .disable();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
