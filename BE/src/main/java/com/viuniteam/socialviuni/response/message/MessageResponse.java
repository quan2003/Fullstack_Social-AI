package com.viuniteam.socialviuni.response.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viuniteam.socialviuni.dto.BaseDTO;
import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;

import lombok.Data;

@Data
public class MessageResponse extends BaseDTO{
	@JsonProperty("user_info")
	private UserInfoResponse userInfoResponse;
	
	private String message;
	
	private String content;
	
}
