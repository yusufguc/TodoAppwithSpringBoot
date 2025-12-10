package com.ysfgc.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	TODO_NOT_FOUND("1001","Todo with given ID not found"),
	TOKEN_İS_EXPIRED("1002","Token is expired"),
	EMAIL_ALREADY_EXIST("1003","Email already exists"),
	EMAIL_OR_PASSWORD_INVALID("1004","Email or Password is incorrect"),
	REFRESH_TOKEN_INVALID("1005","Refresh token is invalid"),
	REFRESH_TOKEN_IS_EXPIRED("1006","Refresh token is expired"),
	GENERAL_EXCEPTION("9999","A general error has occurred");
	
	private String code;
	private String message;
	
	private MessageType(String code,String message) {
		
		this.code=code;
		this.message=message;
	}
}
