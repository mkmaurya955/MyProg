package com.security.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// {noop} => No operation for password encoder	(no password encoding needed)
		auth.inMemoryAuthentication().withUser("devs").password("{noops}password").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("ns").password("{noops}ns").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("vs").password("{noops}vs").authorities("MANAGER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//declares which Page(URL) will have What access type
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/mgr").hasAuthority("MANAGER")
		.antMatchers("/common").hasAnyAuthority("EMPLOYEE","MANAGER")
		
		// Any other URLs which are not configured in above antMatchers
		// generally declared aunthenticated() in real time
		.anyRequest().authenticated()
		
		//Login Form Details
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome", true)
		
		//Logout Form Details
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				
		//Exception Details		
		.and()	
		.exceptionHandling()
		.accessDeniedPage("/accessDenied")
		;
	}

	// Code For versions higher than Spring Security 5.7 and lower than Spring Security 6.0
//	@Bean
//	protected InMemoryUserDetailsManager configAuthentication() {
//		
//		List<UserDetails> users = new ArrayList<>();
//		List<GrantedAuthority> adminAuthority = new ArrayList<>();
//		adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
//		UserDetails admin= new User("devs", "{noop}devs", adminAuthority);
//		users.add(admin);
//		
//		List<GrantedAuthority> employeeAuthority = new ArrayList<>();
//		adminAuthority.add(new SimpleGrantedAuthority("EMPLOYEE"));
//		UserDetails employee= new User("ns", "{noop}ns", employeeAuthority);
//		users.add(employee);
//		
//		List<GrantedAuthority> managerAuthority = new ArrayList<>();
//		adminAuthority.add(new SimpleGrantedAuthority("MANAGER"));
//		UserDetails manager= new User("vs", "{noop}vs", managerAuthority);
//		users.add(manager);
//		
//		return new InMemoryUserDetailsManager(users);
//	}
//	
//	@Bean
//	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		//declares which Page(URL) will have What access type
//		http.authorizeRequests()
//		.antMatchers("/home").permitAll()
//		.antMatchers("/welcome").authenticated()
//		.antMatchers("/admin").hasAuthority("ADMIN")
//		.antMatchers("/emp").hasAuthority("EMPLOYEE")
//		.antMatchers("/mgr").hasAuthority("MANAGER")
//		.antMatchers("/common").hasAnyAuthority("EMPLOYEE","MANAGER")
//		
//		// Any other URLs which are not configured in above antMatchers
//		// generally declared aunthenticated() in real time
//		.anyRequest().authenticated()
//		
//		//Login Form Details
//		.and()
//		.formLogin()
//		.defaultSuccessUrl("/welcome", true)
//		
//		//Logout Form Details
//		.and()
//		.logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				
//		//Exception Details		
//		.and()	
//		.exceptionHandling()
//		.accessDeniedPage("/accessDenied")
//		;
//		
//		return http.build();
//	}
//	
	
//	Code For versions Spring Security 6.0.0 and higher (Spring Boot 3.0+)
//	@Bean
//	protected InMemoryUserDetailsManager configAuthentication() {
//		
//		List<UserDetails> users = new ArrayList<>();
//		List<GrantedAuthority> adminAuthority = new ArrayList<>();
//		adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
//		UserDetails admin= new User("devs", "{noop}devs", adminAuthority);
//		users.add(admin);
//		
//		List<GrantedAuthority> employeeAuthority = new ArrayList<>();
//		adminAuthority.add(new SimpleGrantedAuthority("EMPLOYEE"));
//		UserDetails employee= new User("ns", "{noop}ns", employeeAuthority);
//		users.add(employee);
//		
//		List<GrantedAuthority> managerAuthority = new ArrayList<>();
//		adminAuthority.add(new SimpleGrantedAuthority("MANAGER"));
//		UserDetails manager= new User("vs", "{noop}vs", managerAuthority);
//		users.add(manager);
//		
//		return new InMemoryUserDetailsManager(users);
//	}
//	
//	@Bean
//	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		//declares which Page(URL) will have What access type
//		http.authorizeHttpRequests()
//		.requestMatchers("/home").permitAll()
//		.requestMatchers("/welcome").authenticated()
//		.requestMatchers("/admin").hasAuthority("ADMIN")
//		.requestMatchers("/emp").hasAuthority("EMPLOYEE")
//		.requestMatchers("/mgr").hasAuthority("MANAGER")
//		.requestMatchers("/common").hasAnyAuthority("EMPLOYEE","MANAGER")
//		
//		// Any other URLs which are not configured in above antMatchers
//		// generally declared aunthenticated() in real time
//		.anyRequest().authenticated()
//		
//		//Login Form Details
//		.and()
//		.formLogin()
//		.defaultSuccessUrl("/welcome", true)
//		
//		//Logout Form Details
//		.and()
//		.logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				
//		//Exception Details		
//		.and()	
//		.exceptionHandling()
//		.accessDeniedPage("/accessDenied")
//		;
//		
//		return http.build();
//	}
}
