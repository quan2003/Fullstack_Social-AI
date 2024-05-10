//package com.viuniteam.socialviuni.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.viuniteam.socialviuni.dto.Profile;
//import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
//import com.viuniteam.socialviuni.entity.Chat;
//import com.viuniteam.socialviuni.entity.User;
//
//public interface ChatRepository extends JpaRepository<Chat, Integer>{
//
//	public List<Chat> findByUserId(Long userId);
//	
//	
//	@Query("select c from Chat c Where :user Member of c.users And :reqUser Member of c.users")
//	public Chat findChatByUsersId(@Param("user") UserInfoResponse user, @Param("reqUser") Long long1);
//}
