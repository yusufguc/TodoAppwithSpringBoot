package com.ysfgc.service;

import com.ysfgc.jwt.AuthResponse;
import com.ysfgc.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {

	public AuthResponse refreshToken(RefreshTokenRequest request);
}
