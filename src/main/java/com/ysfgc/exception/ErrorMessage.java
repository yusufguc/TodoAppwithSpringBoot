package com.ysfgc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	
	private MessageType messageType;
	private String ofstatic;
	
	public String prepareErrorMessage() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(messageType.getMessage());
		
		if (ofstatic!= null) {
			stringBuilder.append(" : " + ofstatic );
		}
		
		return stringBuilder.toString();
		
	}

}
