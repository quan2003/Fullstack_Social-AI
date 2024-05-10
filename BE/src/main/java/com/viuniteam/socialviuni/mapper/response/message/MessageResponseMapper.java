package com.viuniteam.socialviuni.mapper.response.message;

import com.viuniteam.socialviuni.dto.response.message.MessageReponse;
import com.viuniteam.socialviuni.entity.Message;
import com.viuniteam.socialviuni.mapper.Mapper;

@org.mapstruct.Mapper(componentModel = "spring")
public interface MessageResponseMapper extends Mapper<Message, MessageReponse> {

}
