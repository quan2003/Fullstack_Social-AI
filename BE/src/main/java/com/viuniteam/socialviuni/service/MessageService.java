package com.viuniteam.socialviuni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.viuniteam.socialviuni.dto.Profile;
import com.viuniteam.socialviuni.dto.request.message.MessageSaveRequest;
import com.viuniteam.socialviuni.dto.request.user.UserSaveRequest;
import com.viuniteam.socialviuni.dto.response.message.MessageReponse;
import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
import com.viuniteam.socialviuni.entity.Message;
import com.viuniteam.socialviuni.entity.User;

public interface MessageService  {
	
	Page<MessageReponse> findAll(Long userTarget, Pageable pageable);
    String remove(Long messageid);
//    MessageReponse findById(Long id);
    Page<MessageReponse> findAllUserMessage(Pageable pageable);
    List<Message> findByUsername(String username);
    MessageReponse createMessage(MessageSaveRequest messageSaveRequest, Long userTarget);
    
}
