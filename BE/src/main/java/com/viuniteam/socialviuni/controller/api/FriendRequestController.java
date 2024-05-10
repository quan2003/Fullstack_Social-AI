package com.viuniteam.socialviuni.controller.api;

import com.viuniteam.socialviuni.dto.response.friendrequest.FriendRequestResponse;
import com.viuniteam.socialviuni.service.FriendRequestService;
import com.viuniteam.socialviuni.utils.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/friendrequest")
public class FriendRequestController {
    private final FriendRequestService friendRequestService;

//    @PostMapping("/add/{id}")
//    public void addFriendRequest(@PathVariable("id") Long idTarget){
//        friendRequestService.addFriendRequest(idTarget);
//    }
    
    @GetMapping("/add/{id}")
    public ResponseEntity<String> addFriendRequest(@PathVariable("id") Long idTarget) {
        return ResponseEntity.ok(friendRequestService.addFriendRequest(idTarget));
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<String> removeFriendRequest(@PathVariable("id") Long idTarget){
        return ResponseEntity.ok().body(friendRequestService.removeFriendRequest(idTarget));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<FriendRequestResponse>> getAllFriendRequest(){
        return ResponseEntity.ok(friendRequestService.getAll());
    }

//    @PostMapping
//    public Page<FriendRequestResponse> getAllFriendRequest(@RequestBody PageInfo pageInfo){
//        PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
//        return friendRequestService.getAllByUser(pageRequest);
//    }
}
