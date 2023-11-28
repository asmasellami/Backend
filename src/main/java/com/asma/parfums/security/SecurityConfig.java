package com.asma.parfums.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		
		   .cors().configurationSource(new CorsConfigurationSource() {
			 @Override
			 public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
			 CorsConfiguration config = new CorsConfiguration();
			 
			config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
			 config.setAllowedMethods(Collections.singletonList("*"));
			 config.setAllowCredentials(true);
			 config.setAllowedHeaders(Collections.singletonList("*"));
			 config.setExposedHeaders(Arrays.asList("Authorization"));
			 config.setMaxAge(3600L);
			 return config;
			 }
			 }).and()

		
				.authorizeHttpRequests()
				.anyRequest().permitAll();
				/*
				//consulter tous les parfums
				 .requestMatchers("/ApiProjet/all/**").hasAnyAuthority("ADMIN","USER")//consulter un produit par son id
				 .requestMatchers(HttpMethod.GET,"/ApiProjet/getbyid/**").hasAnyAuthority("ADMIN","USER")  
				 //ajouter un nouveau parfum
				 .requestMatchers(HttpMethod.POST,"/ApiProjet/addParf/**").hasAuthority("ADMIN")
				 //modifier un parfum
				 .requestMatchers(HttpMethod.PUT,"/ApiProjet/updateParf/**").hasAuthority("ADMIN")
				 //supprimer un parfum
				 .requestMatchers(HttpMethod.DELETE,"/ApiProjet/delParf/**").hasAuthority("ADMIN")
				.anyRequest().authenticated().and()
				 .addFilterBefore(new JWTAuthorizationFilter(),BasicAuthenticationFilter.class);

		*/
		return http.build();
	}
}
