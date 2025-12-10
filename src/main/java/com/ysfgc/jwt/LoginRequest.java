package com.ysfgc.jwt;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	
	@NotBlank(message = "email cannot be empty")
	@Email(message = "email is not in the correct format")
    private String email;
    
	@NotBlank(message = "passwor cannot be empty")
    private String password;
}
