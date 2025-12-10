package com.ysfgc.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysfgc.controller.IAuthController;
import com.ysfgc.jwt.AuthResponse;
import com.ysfgc.jwt.LoginRequest;
import com.ysfgc.jwt.RegisterRequest;
import com.ysfgc.model.RootEntity;
import com.ysfgc.service.IAuthService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthControllerImpl extends RestBaseController implements IAuthController{
	
	@Autowired
	private IAuthService authService;

	@PostMapping("/register")
	@Override
	public RootEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
		return ok(authService.register(registerRequest));
	}

	@PostMapping("/login")
	@Override
	public RootEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
		
		return ok(authService.login(loginRequest));
	}

}
