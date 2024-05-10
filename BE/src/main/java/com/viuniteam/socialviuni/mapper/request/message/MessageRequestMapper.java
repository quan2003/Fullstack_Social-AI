package com.viuniteam.socialviuni.mapper.request.message;

import com.viuniteam.socialviuni.dto.request.message.MessageSaveRequest;
import com.viuniteam.socialviuni.entity.Message;
import com.viuniteam.socialviuni.mapper.Mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface MessageRequestMapper extends Mapper<Message, MessageSaveRequest>{

}
