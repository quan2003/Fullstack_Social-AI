package com.viuniteam.socialviuni.controller.api;

import com.viuniteam.socialviuni.dto.Profile;
import com.viuniteam.socialviuni.dto.request.post.PostFilterRequest;
import com.viuniteam.socialviuni.dto.request.post.PostSaveRequest;
import com.viuniteam.socialviuni.dto.response.post.PostResponse;
import com.viuniteam.socialviuni.service.PostService;
import com.viuniteam.socialviuni.utils.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final Profile profile;
    @PostMapping
    public ResponseEntity<PostResponse> savePost(@Valid @RequestBody PostSaveRequest postSaveRequest){
        return ResponseEntity.ok(postService.save(postSaveRequest));
    }
    @PostMapping("/update/{id}") // update post
    public ResponseEntity<PostResponse> updatePost(@PathVariable("id") Long idPost,@RequestBody @Valid PostSaveRequest postSaveRequest){
        PostResponse post = postService.update(idPost,postSaveRequest);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/delete/{id}") // delete post
    public void deletePost(@PathVariable("id") Long idPost){
        postService.delete(idPost);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> findOneById(@PathVariable("postId") Long postId){
        return ResponseEntity.ok(postService.findOneById(postId));
    }

    @PostMapping("/all/{userId}")
    public ResponseEntity<Page<PostResponse>> getAllByUser(@PathVariable("userId") Long userId, @RequestBody PageInfo pageInfo){
        PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
        Page<PostResponse> posts = postService.findAllByUserId(userId,pageRequest);
        return ResponseEntity.ok(posts);
    }

//    @PostMapping("/all/me")
//    public Page<PostResponse> getAllByMe(@RequestBody PageInfo pageInfo){
//        PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
//        return postService.findAllByUserId(profile.getId(),pageRequest);
//    }
    
    @PostMapping("/all/me")
    public ResponseEntity<Page<PostResponse>> getAllByMe(@RequestBody PageInfo pageInfo) {
        PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
        Page<PostResponse> posts = postService.findAllByUserId(profile.getId(), pageRequest);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<PostResponse>> search(@RequestBody PostFilterRequest postFilterRequest){
        return ResponseEntity.ok(postService.search(postFilterRequest));
    }
    
    @PostMapping("/get/All")
    public ResponseEntity<Page<PostResponse>> getAll(@RequestBody PageInfo pageInfo) {
    	PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
    	Page<PostResponse> posts = postService.getAll(pageRequest);
    	return ResponseEntity.ok(posts);
    }
}
