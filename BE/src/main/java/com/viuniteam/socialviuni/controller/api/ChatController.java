//package com.viuniteam.socialviuni.controller.api;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.viuniteam.socialviuni.controller.AuthController;
//import com.viuniteam.socialviuni.dto.Profile;
//import com.viuniteam.socialviuni.dto.request.createChatRequest.CreateChatRequest;
//import com.viuniteam.socialviuni.entity.Chat;
//import com.viuniteam.socialviuni.service.ChatService;
//import com.viuniteam.socialviuni.service.UserService;
//
//import lombok.AllArgsConstructor;
//
//@RestController
//@AllArgsConstructor
//public class ChatController {
//
//	private final Profile profile;
//	@Autowired
//	private ChatService chatService;
//	
//	@PostMapping("/api/chats")
//	public Chat createChat(@RequestBody CreateChatRequest req) {
//		
//		Chat chat = chatService.createChat(profile.getId(), req.getUser2());
//		
//		return chat;
//	}
//	
//	@GetMapping("/api/chats")
//	public List<Chat> findUserChat() {
//		
//		List<Chat> chats = chatService.findUsersChat(profile.getId());
//		
//		return chats;
//	}
//}
