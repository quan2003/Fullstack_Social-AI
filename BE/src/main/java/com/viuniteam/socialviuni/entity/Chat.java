//package com.viuniteam.socialviuni.entity;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//
//import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//public class Chat extends BaseEntity{
//	
//	private String chat_name;
//	
//	private String chat_img;
//	
//	@ManyToMany
//	private List<UserInfoResponse> users = new ArrayList<>();
//	
//	private LocalDate timestamp;
//}
