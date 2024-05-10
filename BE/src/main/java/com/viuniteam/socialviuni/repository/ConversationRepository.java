package com.viuniteam.socialviuni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viuniteam.socialviuni.entity.Conversation;
import com.viuniteam.socialviuni.entity.User;

public interface ConversationRepository extends JpaRepository<Conversation, String>{
	Optional<Conversation> findBySenderIdAndRecipientId(String senderId, String recipientId);
}