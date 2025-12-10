package com.ysfgc.jwt;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	

	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@NotBlank(message = "email cannot be empty")
	@Email(message = "email is not in the correct format")
	private String email;
	
	@NotBlank(message = "passwor cannot be empty")
	private  String password;


}
