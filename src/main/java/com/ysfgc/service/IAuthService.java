package com.ysfgc.service;

import com.ysfgc.jwt.AuthResponse;
import com.ysfgc.jwt.LoginRequest;
import com.ysfgc.jwt.RegisterRequest;

public interface IAuthService   {
	
	public AuthResponse register(RegisterRequest registerRequest);
	
	public AuthResponse login(LoginRequest loginRequest);

	

}
