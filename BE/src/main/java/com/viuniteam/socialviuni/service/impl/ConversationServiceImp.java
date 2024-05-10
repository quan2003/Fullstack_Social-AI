package com.viuniteam.socialviuni.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.viuniteam.socialviuni.dto.Profile;
import com.viuniteam.socialviuni.dto.utils.Message.MessageResponseUtils;
import com.viuniteam.socialviuni.entity.Conversation;
import com.viuniteam.socialviuni.entity.User;
import com.viuniteam.socialviuni.mapper.request.message.MessageRequestMapper;
import com.viuniteam.socialviuni.repository.ConversationRepository;
import com.viuniteam.socialviuni.repository.MessageRepository;
import com.viuniteam.socialviuni.repository.UserRepository;
import com.viuniteam.socialviuni.service.ConversationService;
import com.viuniteam.socialviuni.service.ImageService;
import com.viuniteam.socialviuni.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConversationServiceImp implements ConversationService{
	
	private final ConversationRepository conversationRepository;
    private final UserService userService;
    private final Profile profile;
    private final UserRepository userRepository;
    
    @Override
	public Optional<String> getConversation(String senderId, String recipientId, boolean createNewRoomIfNotExists) {
	return conversationRepository.findBySenderIdAndRecipientId(senderId, recipientId)
            .map(Conversation::getChatId)
            .or(() -> {
                if(createNewRoomIfNotExists) {
                    var chatId = createConversationId(senderId, recipientId);
                    return Optional.of(chatId);
                }
		return Optional.empty();
	});
	}

	@Override
	public String createConversationId(String senderId, String recipientId) {
		var chatId = String.format("%s_%s", senderId, recipientId);
		Conversation senderRecipient = Conversation
				.builder()
				.chatId(chatId)
				.senderId(senderId)
				.recipientId(recipientId)
				.build();
		
		Conversation recipientSender = Conversation
				.builder()
				.chatId(chatId)
				.senderId(recipientId)
				.recipientId(senderId)
				.build();
		
		conversationRepository.save(senderRecipient);
		conversationRepository.save(recipientSender);
		
		return chatId;
	}


}
