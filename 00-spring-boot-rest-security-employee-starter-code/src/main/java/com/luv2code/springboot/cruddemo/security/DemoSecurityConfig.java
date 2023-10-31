package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager () {
		
		UserDetails hamza = User.builder()
				.username("hamza")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails alvi = User.builder()
				.username("alvi")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		
		UserDetails hassan = User.builder()
				.username("hassan")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(hamza, alvi , hassan);
	}
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
		{
			http.authorizeHttpRequests(configurer ->
			configurer
			      .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
			      .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
			      .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
			      .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
			      .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
			
					);
			// use basic authentication
			http.httpBasic(Customizer.withDefaults());
			
			//
			//
			http.csrf(csrf ->csrf.disable());
			return http.build();
		}
		
		
	}

