//package com.viuniteam.socialviuni.service.impl;
//
//import java.time.LocalDate;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.viuniteam.socialviuni.dto.Profile;
//import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
//import com.viuniteam.socialviuni.entity.Chat;
//import com.viuniteam.socialviuni.repository.ChatRepository;
//import com.viuniteam.socialviuni.service.ChatService;
//
//@Service
//public class ChatServiceImp implements ChatService{
//	
//
//	@Autowired
//	private ChatRepository chatRepository;
//	@Override
//	public Chat createChat(Profile reqUser, UserInfoResponse user2) {
//		Chat isExit = chatRepository.findChatByUsersId(user2, reqUser);
//		
//		if(isExit!=null) {
//			return isExit;
//		}
//		Chat chat = new Chat();
//		chat.getUsers().add(user2);
//		chat.setUsers(isExit.getUsers());
//		chat.setTimestamp(LocalDate.now());
//
//		return chatRepository.save(chat);
//	}
//
//	@Override
//	public Chat findChatById(Integer chatId) throws Exception {
//		Optional<Chat> opt = chatRepository.findById(chatId);
//		
//		if (opt.isEmpty()) {
//			throw new Exception("chat not found with id: " + chatId);
//		}
//		return opt.get();
//	}
//
//	@Override
//	public List<Chat> findUsersChat(Long userId) {
//		// TODO Auto-generated method stub
//		return chatRepository.findByUserId(userId);
//	}
//
//}
