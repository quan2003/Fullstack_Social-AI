package com.viuniteam.socialviuni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.viuniteam.socialviuni.dto.Profile;
import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
import com.viuniteam.socialviuni.entity.Comment;
import com.viuniteam.socialviuni.entity.Message;
import com.viuniteam.socialviuni.entity.Post;
import com.viuniteam.socialviuni.entity.User;

public interface MessageRepository extends JpaRepository<Message, Long>{
	Message findOneById(Long id);
	void deleteById(Long id);
	
	@Query("SELECT m FROM Message m WHERE (m.userSource = :userSource AND m.userTarget = :userTarget) OR (m.userSource = :userTarget AND m.userTarget = :userSource) ORDER BY created_date DESC")
	Page<Message> findAllByIdUserSourceAndUserTarget(@Param("userSource") User userSource, @Param("userTarget") User userTarget, Pageable pageable);

	
	@Query(value = "SELECT * FROM message WHERE user_source_id = :userSource GROUP BY user_target_id", nativeQuery = true)
	Page<Message> findAllByUserMessage(@Param("userSource") User userSource, Pageable pageable);

}	