package com.server.boardd.domain.board.service;

import com.server.boardd.domain.board.domain.entity.Post;
import com.server.boardd.domain.board.dto.request.PostRequest;

public interface BoardService {
    void savePost(PostRequest request);
    Post getPost(Long postId);
    void deletePost(Long postId);
    void updatePost(Long id, String change, String attribute);
    void putPost(Long id, PostRequest request);
}
