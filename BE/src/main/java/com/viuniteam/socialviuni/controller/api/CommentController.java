package com.viuniteam.socialviuni.controller.api;

import com.viuniteam.socialviuni.dto.request.comment.CommentSaveRequest;
import com.viuniteam.socialviuni.dto.request.comment.CommentUpdateRequest;
import com.viuniteam.socialviuni.dto.response.comment.CommentResponse;
import com.viuniteam.socialviuni.service.CommentService;
import com.viuniteam.socialviuni.utils.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<CommentResponse> addComment(@RequestBody @Valid CommentSaveRequest commentSaveRequest, @PathVariable("postId") Long postId){
        return ResponseEntity.ok(commentService.save(commentSaveRequest,postId));
    }

    @PostMapping("/update")
    public ResponseEntity<CommentResponse> updateComment(@RequestBody @Valid CommentUpdateRequest commentUpdateRequest){
        return ResponseEntity.ok(commentService.update(commentUpdateRequest));
    }

    @PostMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId){
        commentService.delete(commentId);
    }

    @PostMapping("/all/{postId}")
    public ResponseEntity<Page<CommentResponse>> getAll(@PathVariable("postId") Long postId, @RequestBody PageInfo pageInfo){
        PageRequest pageRequest = PageRequest.of(pageInfo.getIndex(), pageInfo.getSize());
        return ResponseEntity.ok(commentService.findAllByPost(postId,pageRequest));
    }
}
