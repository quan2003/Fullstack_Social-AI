package com.viuniteam.socialviuni.dto.request.message;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viuniteam.socialviuni.annotation.offensivekeyword.ValidOffensiveKeyword;
import com.viuniteam.socialviuni.dto.BaseDTO;
import com.viuniteam.socialviuni.entity.User;

import lombok.Data;

@Data
public class MessageSaveRequest{
	@NotEmpty(message = "Nội dung không được để trống")
	@ValidOffensiveKeyword
	private String content;

	
}
