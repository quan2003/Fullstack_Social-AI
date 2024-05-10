package com.viuniteam.socialviuni.dto.utils.Message;

import org.springframework.stereotype.Component;

import com.viuniteam.socialviuni.dto.response.comment.CommentResponse;
import com.viuniteam.socialviuni.dto.response.message.MessageReponse;
import com.viuniteam.socialviuni.dto.utils.ResponseUtilsAdapter;
import com.viuniteam.socialviuni.dto.utils.user.UserAuthorResponseUtils;
import com.viuniteam.socialviuni.dto.utils.user.UserInfoResponseUtils;
import com.viuniteam.socialviuni.entity.Comment;
import com.viuniteam.socialviuni.entity.Message;
import com.viuniteam.socialviuni.entity.User;
import com.viuniteam.socialviuni.mapper.response.comment.CommentResponseMapper;
import com.viuniteam.socialviuni.mapper.response.image.ImageReponseMapper;
import com.viuniteam.socialviuni.mapper.response.message.MessageResponseMapper;
import com.viuniteam.socialviuni.utils.ListUtils;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MessageResponseUtils extends ResponseUtilsAdapter<Message, MessageReponse>{
	private final MessageResponseMapper messageResponseMapper;
	private final UserInfoResponseUtils userInfoResponseUtils;
    private final UserAuthorResponseUtils userAuthorResponseUtils;
    @Override
    public MessageReponse convert(Message obj) {
        MessageReponse messageResponse = messageResponseMapper.from(obj);
        messageResponse.setUserSource(userInfoResponseUtils.convert(obj.getUserSource()));
        messageResponse.setUserTarget(userInfoResponseUtils.convert(obj.getUserTarget()));
        return messageResponse;
    }
}
