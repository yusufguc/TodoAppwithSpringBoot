package com.ysfgc.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ysfgc.config.SecurityConfig;
import com.ysfgc.exception.BaseException;
import com.ysfgc.exception.ErrorMessage;
import com.ysfgc.exception.MessageType;
import com.ysfgc.jwt.AuthResponse;
import com.ysfgc.jwt.JwtService;
import com.ysfgc.jwt.LoginRequest;
import com.ysfgc.jwt.RegisterRequest;
import com.ysfgc.model.RefreshToken;
import com.ysfgc.model.User;
import com.ysfgc.repository.RefreshTokenRepository;
import com.ysfgc.repository.UserRepository;
import com.ysfgc.service.CreateRefreshToken;
import com.ysfgc.service.IAuthService;

@Service
public class IAuthServiceImpl implements IAuthService {

    @Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Autowired
	private CreateRefreshToken createRefreshToken;
    
	@Override
	public AuthResponse register(RegisterRequest registerRequest) {
		
		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			throw new BaseException(new ErrorMessage(MessageType.EMAIL_ALREADY_EXIST,registerRequest.getEmail()));	
		}
		
		User user=new User();
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword())) ;
		user.setName(registerRequest.getName());
		
		User savedUser = userRepository.save(user);
	
		String token = jwtService.generateToken(savedUser);
		
		RefreshToken refreshToken=createRefreshToken.createRefreshToken(savedUser);
		refreshTokenRepository.save(refreshToken);
		
		return new AuthResponse(token,refreshToken.getRefreshToken());
		
	}
	
	
	@Override
	public AuthResponse login(LoginRequest loginRequest) {
		
		try {
			UsernamePasswordAuthenticationToken auth= 
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
			authenticationProvider.authenticate(auth);
			
			Optional<User> optionalEmail = userRepository.findByEmail(loginRequest.getEmail());
			
			String token = jwtService.generateToken(optionalEmail.get());


			RefreshToken refreshToken=createRefreshToken.createRefreshToken(optionalEmail.get());
			refreshTokenRepository.save(refreshToken);
			
			return new AuthResponse(token,refreshToken.getRefreshToken());
			
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.EMAIL_OR_PASSWORD_INVALID,null));
		}
	}

	


	

	
	
	
	
	
	
	
	
	
	
}
