package com.ysfgc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ysfgc.jwt.AuthEntryPoint;
import com.ysfgc.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	public static final String AUTHENTICATE="/auth/login";
	public static final String REGISTER="/auth/register";
	public static final String REFRESH_TOKEN="/auth/refreshToken";
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private AuthEntryPoint authEntryPoint;
	
	
	
	
	public static final String[] SWAGGER_PATHS = {
			"/swagger-ui/**",
			"/v3/api-docs/**",
			"/swagger-ui.html"
	};
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth-> auth
				.requestMatchers(AUTHENTICATE,REGISTER,REFRESH_TOKEN).permitAll()
				.requestMatchers(SWAGGER_PATHS).permitAll()
				.anyRequest().authenticated()
				)
		.exceptionHandling(ex-> ex.authenticationEntryPoint(authEntryPoint)
				)
		.sessionManagement(session-> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	

}
