package com.viuniteam.socialviuni.controller.api;

import com.viuniteam.socialviuni.dto.Profile;
import com.viuniteam.socialviuni.dto.response.friend.FriendResponse;
import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
import com.viuniteam.socialviuni.service.FriendService;
import com.viuniteam.socialviuni.utils.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;
    private final Profile profile;

    @GetMapping("/add/{id}")
    public ResponseEntity<String> addFriend(@PathVariable("id") Long idTarget){
        return ResponseEntity.ok(friendService.addFriend(profile.getId(),idTarget));
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<String> removeFriend(@PathVariable("id") Long idTarget){
        return ResponseEntity.ok(friendService.removeFriend(profile.getId(),idTarget));
    }
    @GetMapping("/getall/{id}")
    public ResponseEntity<List<FriendResponse>> getAllFriend(@PathVariable("id") Long id){
        return ResponseEntity.ok(friendService.getAll(id));
    }

    @GetMapping("/getall/me")
    public ResponseEntity<List<FriendResponse>> getAllMyFriend(){
        return ResponseEntity.ok(friendService.getAll(profile.getId()));
    }

//    @PostMapping("/getall/{id}")
//    public Page<FriendResponse> getAllFriend(@PathVariable("id") Long id, @RequestBody PageInfo pageInfo){
//        PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
//        return friendService.getAllByUserId(id,pageRequest);
//    }
//    @PostMapping("/getall/me")
//    public Page<FriendResponse>getAllMyFriend(@RequestBody PageInfo pageInfo){
//        PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
//        return friendService.getAllByUserId(profile.getId(),pageRequest);
//    }

    @PostMapping("/friend-suggestion")
    public List<UserInfoResponse> getListFriendSuggestion(){
        return friendService.listFriendSuggestions(profile.getId());
    }
}
