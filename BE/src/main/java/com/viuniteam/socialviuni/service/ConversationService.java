package com.viuniteam.socialviuni.service;

import java.util.Optional;

import com.viuniteam.socialviuni.entity.User;

public interface ConversationService {
 Optional<String> getConversation(String senderId, String recipientId, boolean createNewRoomIfNotExists);
 String createConversationId(String senderId, String recipientId);
}
