package com.ysfgc.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ysfgc.exception.BaseException;
import com.ysfgc.exception.ErrorMessage;
import com.ysfgc.exception.MessageType;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header;
		String token;
		String username;
		
		header=request.getHeader("Authorization");
		
		
		if (header == null || !header.startsWith("Bearer ")) {
		    filterChain.doFilter(request, response);
		    return;
		}

		token=header.substring(7);
		try {
			username=jwtService.getUsernameByToken(token);
			if (username !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
				if (userDetails!= null && jwtService.isTokenNotExpired(token)) {
					UsernamePasswordAuthenticationToken authentication=
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); //dikkat et
					
					authentication.setDetails(userDetails);
					 
					SecurityContextHolder.getContext().setAuthentication(authentication);
					
				}
			}
			
		} catch (ExpiredJwtException e) {
			throw new BaseException(new ErrorMessage(MessageType.TOKEN_İS_EXPIRED,e.getMessage()));
		}catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,e.getMessage()));
		}
		filterChain.doFilter(request, response);
	}
	
}
