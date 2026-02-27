package com.example.ldap.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class LdapSecurityConfig  extends WebSecurityConfigurerAdapter {

	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
	       http
	        .authorizeRequests()
	        .anyRequest().fullyAuthenticated()
	        .and()
	        .formLogin();
	   }

	   @Override
	   public void configure(AuthenticationManagerBuilder auth) throws Exception {
	       auth
	        .ldapAuthentication()
	        .userDnPatterns("uid={0},ou=people")
	        .groupSearchBase("ou=groups")
	        .contextSource()
	        .url("ldap://localhost:8389/dc=springframework,dc=org")
	        .and()
	        .passwordCompare()
	        .passwordEncoder(new BCryptPasswordEncoder())
	        .passwordAttribute("userPassword");
	   }
	
//
//protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//    http
//     .authorizeHttpRequests()
//     .anyRequest().fullyAuthenticated()
//     .and()
//     .formLogin();
//    http.authenticationProvider(ldapAuthenticationProvider());
//    return http.build();
//  }
//
//  @Bean
//  LdapAuthenticationProvider ldapAuthenticationProvider() {
//     return new LdapAuthenticationProvider(authenticator());
//  }
//
//  @Bean
//  BindAuthenticator authenticator() {
//
//     FilterBasedLdapUserSearch search = new FilterBasedLdapUserSearch("ou=groups", "(uid={0})", contextSource());
//     BindAuthenticator authenticator = new BindAuthenticator(contextSource());
//     authenticator.setUserSearch(search);
//     return authenticator;
//  }
//
//  @Bean
//  public DefaultSpringSecurityContextSource contextSource() {
//     DefaultSpringSecurityContextSource dsCtx = new DefaultSpringSecurityContextSource("ldap://localhost:8389/dc=springframework,dc=org");
//     dsCtx.setUserDn("uid={0},ou=people");
//     return dsCtx;
//  }
//}

}
