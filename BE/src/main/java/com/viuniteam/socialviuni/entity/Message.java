package com.viuniteam.socialviuni.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Message extends BaseEntity{

    private String content;
    @ManyToOne
    @JoinColumn(name = "user_source_id")
    private User userSource;
    @ManyToOne
    @JoinColumn(name = "user_target_id")
    private User userTarget;

    private String chatId;
    
    @ManyToMany
    @JoinTable(name = "message_images",joinColumns = @JoinColumn(name = "message_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "image_id",nullable = false))
    private List<Image> image = new ArrayList<>();

//    public void determineAndSetChatRoom() {
//        if (userSource != null && userTarget != null) {
//            // Kiểm tra xem đã tồn tại cuộc trò chuyện giữa hai người dùng này chưa
//            Conversation conversation = conversationRepository.findByUser1AndUser2(userSource, userTarget);
//            if (conversation != null) {
//                this.chatRoom = conversation.getChatRoom();
//            } else {
//                // Tạo một chatRoom mới và lưu thông tin của nó
//                Conversation newConversation = new Conversation();
//                newConversation.setUser1(userSource);
//                newConversation.setUser2(userTarget);
//                newConversation.setChatRoom(generateNewChatRoomId()); // Hàm để tạo ID chatRoom mới
//                conversationRepository.save(newConversation);
//                this.chatRoom = newConversation.getChatRoom();
//            }
//        }
//    }

}
