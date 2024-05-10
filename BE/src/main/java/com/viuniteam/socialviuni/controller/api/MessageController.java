package com.viuniteam.socialviuni.controller.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.viuniteam.socialviuni.dto.Profile;
import com.viuniteam.socialviuni.dto.request.message.MessageSaveRequest;
import com.viuniteam.socialviuni.dto.response.message.MessageReponse;
import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
import com.viuniteam.socialviuni.entity.Message;
import com.viuniteam.socialviuni.service.MessageService;
import com.viuniteam.socialviuni.service.UserService;
import com.viuniteam.socialviuni.utils.PageInfo;

import javassist.tools.rmi.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/message")
public class MessageController {
	private final UserService userService;
    private final Profile profile;
    
    private final MessageService messageService;
    
    
    
    @PostMapping("/chat/{userTarget}")
    public ResponseEntity<MessageReponse> creaMessage(@PathVariable("userTarget") Long userTarget, @RequestBody @Valid MessageSaveRequest messageSaveRequest) {
    	return ResponseEntity.ok(messageService.createMessage(messageSaveRequest, userTarget));
    }
    
    @PostMapping("/getMessage/{userTarget}")
    public ResponseEntity<Page<MessageReponse>> getAll(@PathVariable("userTarget") Long userTarget,@RequestBody PageInfo pageInfo) {
    	PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
    	
    	return ResponseEntity.ok(messageService.findAll(userTarget, pageRequest));
    }
    
    @PostMapping("/delete/{messageId}")
	public ResponseEntity<String> deleteMessageByid(@PathVariable("messageId") Long messageId){
    	return ResponseEntity.ok(messageService.remove(messageId));
    }
    
    @PostMapping("/allUser/message/me")
    public ResponseEntity<Page<MessageReponse>> getAlluserMessage(@RequestBody PageInfo pageInfo) {
    	PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
    	return ResponseEntity.ok(messageService.findAllUserMessage(pageRequest));
    }
}
