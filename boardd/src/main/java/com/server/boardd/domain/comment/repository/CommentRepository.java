package com.server.boardd.domain.comment.repository;

import com.server.boardd.domain.comment.domain.entity.Comment;
import com.server.boardd.domain.comment.dto.response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<CommentResponse> findAllByBoardId(Long boardId);
}
