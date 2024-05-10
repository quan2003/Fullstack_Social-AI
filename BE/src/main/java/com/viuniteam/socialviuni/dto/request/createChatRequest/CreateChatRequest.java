package com.viuniteam.socialviuni.dto.request.createChatRequest;

import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
import com.viuniteam.socialviuni.entity.User;

import lombok.Data;

@Data
public class CreateChatRequest {
	private UserInfoResponse reqUser;
	
	private UserInfoResponse user2;

}
