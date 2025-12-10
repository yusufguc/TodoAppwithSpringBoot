package com.ysfgc.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ysfgc.model.RefreshToken;
import com.ysfgc.model.User;
import com.ysfgc.service.CreateRefreshToken;

@Service
public class CreateRefreshTokenImpl implements CreateRefreshToken{
	
	@Override
	public RefreshToken createRefreshToken(User user) {
		
		RefreshToken refreshToken=new RefreshToken();
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
		refreshToken.setUser(user);
		return refreshToken;
	}



}
