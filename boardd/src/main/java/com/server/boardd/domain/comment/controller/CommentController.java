package com.server.boardd.domain.comment.controller;

import com.server.boardd.domain.comment.dto.response.CommentResponse;
import com.server.boardd.domain.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/board/post/{id}/comment")
@Tag(name = "댓글 API", description = "게시물 댓글 관련 API")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{userId}/write")
    @Operation(summary = "댓글 작성", description = "댓글 작성 API")
    public HttpEntity<HttpStatus> writeComment(@PathVariable Long id, @PathVariable Long userId, @RequestBody String content) {
        commentService.writeComment(id, userId, content);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/read")
    @Operation(summary = "댓글 불러오기", description = "게시물 댓글 전체 불러오기")
    public List<CommentResponse> readComments(@PathVariable Long id) {
        return commentService.readComments(id);
    }
}
