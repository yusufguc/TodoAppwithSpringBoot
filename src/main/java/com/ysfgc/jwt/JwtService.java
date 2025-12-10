package com.ysfgc.jwt;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	public static final  String SECRET_KEY="0ME3IQMQTCYD8lxpUFcbTTNqLVvRl2Zw97SBLlrEf1w=";
	
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
		.setSubject(userDetails.getUsername())
		.setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*2))
		.signWith(getKey(),SignatureAlgorithm.HS256)
		.compact();
	}
	
	public  Claims getClaims(String token) {
		 Claims claims = Jwts.parser()
		.setSigningKey(getKey())
		.build()
		.parseClaimsJws(token).getBody();
		 
		 return claims;
	}
	
	public <T> T exportToken(String token,Function<Claims, T> claimsFunction) {
		Claims claims = getClaims(token);
		return claimsFunction.apply(claims);
	}
	
	public String getUsernameByToken(String token) {
		return exportToken(token, Claims::getSubject);
	}
	
	public boolean isTokenNotExpired(String token) {
		Date expireDate =exportToken(token, Claims::getExpiration);
		return new Date().before(expireDate);
	}
 	
	
	public  Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
