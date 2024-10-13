package com.server.boardd.domain.comment.service;

import com.server.boardd.domain.comment.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {
    void writeComment(Long id, Long userId, String content);
    List<CommentResponse> readComments(Long id);
}
