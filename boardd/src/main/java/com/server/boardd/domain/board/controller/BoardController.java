package com.server.boardd.domain.board.controller;

import com.server.boardd.domain.board.domain.entity.Post;
import com.server.boardd.domain.board.dto.request.PostRequest;
import com.server.boardd.domain.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/post")
@Tag(name = "게시물 API", description = "게시물 관련 API")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    @Operation(summary = "게시물 작성", description = "게시물 작성 API")
    public HttpEntity<HttpStatus> postPost(@RequestBody PostRequest request) {
        boardService.savePost(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/read")
    @Operation(summary = "게시물 내용 불러오기", description = "게시물 상세내용 불러오기")
    public Post getBoard(@RequestBody Long id) {
        return boardService.getPost(id);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "게시물 삭제", description = "게시물 삭제하기")
    public HttpEntity<HttpStatus> deleteBoard(@RequestBody Long id) {
        boardService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/attribute/{id}")
    @Operation(summary = "게시물 일부 변경", description = "change에 변경후 내용 입력, attribute에 title 혹은 content 입력")
    public HttpEntity<HttpStatus> patchBoardTitle(@PathVariable Long id, @RequestBody String change, @RequestBody String attribute) {
        boardService.updatePost(id, change, attribute);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    @Operation(summary = "게시물 내용 변경", description = "게시물 전체 내용 변경")
    public HttpEntity<HttpStatus> putBoardTitle(@PathVariable Long id, @RequestBody PostRequest request) {
        boardService.putPost(id, request);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
