package com.server.boardd.domain.comment.service.impl;

import com.server.boardd.domain.comment.domain.entity.Comment;
import com.server.boardd.domain.comment.dto.response.CommentResponse;
import com.server.boardd.domain.comment.repository.CommentRepository;
import com.server.boardd.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public void writeComment(Long id, Long userId, String content) {
        Comment comment = Comment.builder()
                .boardId(id)
                .commentAuthor(userId)
                .commentContent(content)
                .build();
    }

    @Override
    public List<CommentResponse> readComments(Long id) {
        return commentRepository.findAllByBoardId(id);
    }
}
