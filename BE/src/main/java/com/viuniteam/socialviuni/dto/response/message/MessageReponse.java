package com.viuniteam.socialviuni.dto.response.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viuniteam.socialviuni.dto.BaseDTO;
import com.viuniteam.socialviuni.dto.response.friend.FriendResponse;
import com.viuniteam.socialviuni.dto.response.user.UserAuthorResponse;
import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;

import lombok.Data;

@Data
public class MessageReponse extends BaseDTO{
	@JsonProperty("user_Source")
	private UserInfoResponse userSource;
	
	@JsonProperty("user_Target")
	private UserInfoResponse userTarget;
	
	private String content;
	
	private String chatId;

}
