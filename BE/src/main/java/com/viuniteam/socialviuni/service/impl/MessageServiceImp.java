package com.viuniteam.socialviuni.service.impl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viuniteam.socialviuni.dto.Profile;
import com.viuniteam.socialviuni.dto.request.message.MessageSaveRequest;
import com.viuniteam.socialviuni.dto.request.user.UserSaveRequest;
import com.viuniteam.socialviuni.dto.response.message.MessageReponse;
import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
import com.viuniteam.socialviuni.dto.utils.Message.MessageResponseUtils;
import com.viuniteam.socialviuni.dto.utils.comment.CommentResponseUtils;
import com.viuniteam.socialviuni.entity.Message;
import com.viuniteam.socialviuni.entity.User;
import com.viuniteam.socialviuni.exception.BadRequestException;
import com.viuniteam.socialviuni.exception.OKException;
import com.viuniteam.socialviuni.exception.ObjectNotFoundException;
import com.viuniteam.socialviuni.mapper.request.comment.CommentRequestMapper;
import com.viuniteam.socialviuni.mapper.request.comment.CommentUpdateRequestMapper;
import com.viuniteam.socialviuni.mapper.request.message.MessageRequestMapper;
import com.viuniteam.socialviuni.mapper.request.user.UserRequestMapper;
import com.viuniteam.socialviuni.repository.CommentRepository;
import com.viuniteam.socialviuni.repository.ConversationRepository;
import com.viuniteam.socialviuni.repository.MessageRepository;
import com.viuniteam.socialviuni.repository.PostRepository;
import com.viuniteam.socialviuni.repository.UserRepository;
import com.viuniteam.socialviuni.repository.notification.NotificationPostRepository;
import com.viuniteam.socialviuni.repository.notification.NotificationRepository;
import com.viuniteam.socialviuni.service.ConversationService;
import com.viuniteam.socialviuni.service.ImageService;
import com.viuniteam.socialviuni.service.MessageService;
import com.viuniteam.socialviuni.service.NotificationService;
import com.viuniteam.socialviuni.service.PostService;
import com.viuniteam.socialviuni.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageServiceImp implements MessageService{
	private final MessageRequestMapper messageRequestMapper;
    private final Profile profile;
    private final UserService userService;
    private final MessageRepository messageRepository;
    private final MessageResponseUtils messageResponseUtils;
    private final ImageService imageService;
    private final UserRepository userRepository;
    private final ConversationRepository conversationRepository;
    private final ConversationService conversationService;
    
	@Override
	public Page<MessageReponse> findAll(Long userTarget, Pageable pageable) {
		// TODO Auto-generated method stub
		User userSource = userService.findOneById(profile.getId());
		User usertarget = userRepository.findOneById(userTarget);
		Page<Message> messagePage = messageRepository.findAllByIdUserSourceAndUserTarget(userSource, usertarget, pageable);
		List<MessageReponse> messageReponses = messagePage
				.stream()
				.filter(message -> message.getUserSource().isActive() || userService.isAdmin(profile))
				.map(messageResponseUtils::convert)
				.collect(Collectors.toList());
		Collections.sort(messageReponses, new Comparator<MessageReponse>() { // sap xep lai message theo thu tu tang dan cua id
			@Override
			public int compare(MessageReponse o1, MessageReponse o2) {
				if(o1.getId()>o2.getId())
					return 1;
				else if (o1.getId()<o2.getId()) 
					return -1;
				else 
					return 1;
			}
		});
		return new PageImpl<>(messageReponses,pageable,messageReponses.size());
	}

	@Override
	public String remove(Long messageId) {
		// TODO Auto-generated method stub
		Message message = messageRepository.findOneById(messageId);
		if(message == null)
			throw new ObjectNotFoundException("tin nhắn không tồn tại");
		
		if(!message.getUserTarget().isActive() && !userService.isAdmin(profile))
			throw new ObjectNotFoundException("người dùng không tồn tại");
		
		if(message.getUserSource().getId().equals(profile.getId()) || userService.isAdmin(profile)) {
			messageRepository.deleteById(messageId);
			throw new OKException("Xóa tin nhắn thành công");
		}
		throw new BadRequestException("Bạn không có quyền xóa tin nhắn này");
	}

	@Override
	public List<Message> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageReponse createMessage(MessageSaveRequest messageSaveRequest, Long userTarget) {
		// TODO Auto-generated method stub
		Message message = messageRequestMapper.to(messageSaveRequest);
		User userSource = userService.findOneById(profile.getId());
		message.setUserSource(userSource);
		message.setUserTarget(userService.findOneById(userTarget));
		var chatId = conversationService.getConversation(message.getUserSource().getId().toString(), message.getUserTarget().getId().toString(), true)
		.orElseThrow();
//		String saveChatid = conversationService.createConversationId(message.getUserSource().getId().toString(), message.getUserTarget().getId().toString());
		message.setChatId(chatId);;
		Message  messageSuccess = messageRepository.save(message);
		return messageResponseUtils.convert(messageSuccess);
	}

	@Override
	public Page<MessageReponse> findAllUserMessage(Pageable pageable) {
		// TODO Auto-generated method stub
		User userSource = userService.findOneById(profile.getId());
		Page<Message> userMessages = messageRepository.findAllByUserMessage(userSource, pageable);
		List<MessageReponse> messageReponses = userMessages
				.stream()
				.filter(message -> message.getUserSource().isActive() || userService.isAdmin(profile))
				.map(messageResponseUtils::convert)
				.collect(Collectors.toList());
		Collections.sort(messageReponses, new Comparator<MessageReponse>() { // sap xep lai message theo thu tu tang dan cua id
			@Override
			public int compare(MessageReponse o1, MessageReponse o2) {
				if(o1.getId()>o2.getId())
					return -1;
				else if (o1.getId()<o2.getId()) 
					return 1;
				else 
					return 1;
			}
		});
		return  new PageImpl<>(messageReponses,pageable,messageReponses.size());
	}



}
