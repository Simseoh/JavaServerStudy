package com.server.boardd.domain.board.repository;

import com.server.boardd.domain.board.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findAllById(Long postId);
    void deleteById(Long Id);
    boolean existsById(Long Id);
}
