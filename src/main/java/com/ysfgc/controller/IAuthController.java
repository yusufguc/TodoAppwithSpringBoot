package com.ysfgc.controller;

import com.ysfgc.jwt.AuthResponse;
import com.ysfgc.jwt.LoginRequest;
import com.ysfgc.jwt.RefreshTokenRequest;
import com.ysfgc.jwt.RegisterRequest;
import com.ysfgc.model.RootEntity;

public interface IAuthController {
	
	public RootEntity<AuthResponse> register(RegisterRequest registerRequest);
	
	public RootEntity<AuthResponse> login(LoginRequest loginRequest);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest request);

}
