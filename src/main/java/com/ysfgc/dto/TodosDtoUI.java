
package com.ysfgc.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodosDtoUI{
	
	@NotBlank(message = "title cannot be empty")
	private String title;
	
	@NotBlank(message = "description cannot be empty")
	private String description;
	

}
