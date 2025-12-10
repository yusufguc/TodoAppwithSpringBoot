package com.ysfgc.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysfgc.exception.BaseException;
import com.ysfgc.exception.ErrorMessage;
import com.ysfgc.jwt.AuthResponse;
import com.ysfgc.jwt.JwtService;
import com.ysfgc.jwt.RefreshTokenRequest;
import com.ysfgc.model.RefreshToken;
import com.ysfgc.repository.RefreshTokenRepository;
import com.ysfgc.service.CreateRefreshToken;
import com.ysfgc.service.IRefreshTokenService;
import com.ysfgc.exception.MessageType;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService{
	
	@Autowired
	private CreateRefreshToken createRefreshToken;
	
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private JwtService jwtService;
	
	private boolean isRefreshTokenExpired(Date expireDate) {
		return new Date().before(expireDate);
	}
	

	@Override
	public AuthResponse refreshToken(RefreshTokenRequest request) {
		
		Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
		if (optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_INVALID,request.getRefreshToken()));
		}
		
		RefreshToken refreshToken = optional.get();
		
		if (!isRefreshTokenExpired(refreshToken.getExpireDate())) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED,request.getRefreshToken()));
		}
		
		String token = jwtService.generateToken(refreshToken.getUser());
		RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken.createRefreshToken(refreshToken.getUser()));
		
		
		return new AuthResponse(token,savedRefreshToken.getRefreshToken());
	}

}
