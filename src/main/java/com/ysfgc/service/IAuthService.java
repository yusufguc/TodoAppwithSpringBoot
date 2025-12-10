package com.ysfgc.service;

import com.ysfgc.jwt.AuthResponse;
import com.ysfgc.jwt.LoginRequest;
import com.ysfgc.jwt.RegisterRequest;
import com.ysfgc.model.RefreshToken;
import com.ysfgc.model.User;

public interface IAuthService   {
	
	public AuthResponse register(RegisterRequest registerRequest);
	
	public AuthResponse login(LoginRequest loginRequest);
	

	

}
