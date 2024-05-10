package com.viuniteam.socialviuni.controller.api;

import com.viuniteam.socialviuni.dto.Profile;
import com.viuniteam.socialviuni.dto.request.user.UserFilterRequest;
import com.viuniteam.socialviuni.dto.request.user.UserUpdateInfoRequest;
import com.viuniteam.socialviuni.dto.response.user.UserInfoResponse;
import com.viuniteam.socialviuni.entity.User;
import com.viuniteam.socialviuni.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final Profile profile;
    @GetMapping("/{id}")
    public UserInfoResponse findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/me")
    public ResponseEntity<UserInfoResponse> findById(){
        return ResponseEntity.ok(userService.findById(profile.getId()));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserInfoResponse> findByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @PostMapping("/update")
    public void updateInfo(@Valid @RequestBody UserUpdateInfoRequest userUpdateInfoRequest){
        userService.updateInfo(userUpdateInfoRequest);
    }

    @PostMapping("/search")
    public Page<UserInfoResponse> search(@RequestBody UserFilterRequest userFilterRequest){
        return userService.search(userFilterRequest);
    }
    
    @GetMapping("/usSearch")
    public ResponseEntity<List<User>> findByKey(@RequestParam(value = "keyword", required = false) String keyword) {
    	return ResponseEntity.ok(userService.findByUser(keyword));
    }
}
