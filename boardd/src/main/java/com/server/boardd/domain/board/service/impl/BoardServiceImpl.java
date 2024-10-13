package com.server.boardd.domain.board.service.impl;

import com.server.boardd.domain.board.domain.entity.Post;
import com.server.boardd.domain.board.dto.request.PostRequest;
import com.server.boardd.domain.board.exception.impl.IdNotFound;
import com.server.boardd.domain.board.repository.PostRepository;
import com.server.boardd.domain.board.service.BoardService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final PostRepository postRepository;

    @Override
    public void savePost(PostRequest request) {

        Post post = Post.builder()
                .title(request.title())
                .author(request.author())
                .content(request.content())
                .build();

        postRepository.save(post);
    }

    @Override
    public Post getPost(Long postId) {
        return postRepository.findAllById(postId);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public void updatePost(Long id, String change, String attribute) {

        if (attribute.equals("title")) {
            updateTitle(id,change);
        } else if (attribute.equals("author")) {
            updateAuthor(id, change);
        }
    }

    @Override
    public void putPost(Long id, PostRequest request) {
        Post post = postRepository.findById(id).orElseThrow(() -> IdNotFound.INSTANCE);

        post.setTitle(request.title());
        post.setAuthor(request.author());
        post.setContent(request.content());
    }

    private void updateTitle(Long id, String title) {
        Post post = postRepository.findById(id).orElseThrow(() -> IdNotFound.INSTANCE);
        post.setTitle(title);
    }
    private void updateAuthor(Long id, String author) {
        Post post = postRepository.findById(id).orElseThrow(() -> IdNotFound.INSTANCE);
        post.setAuthor(author);
    }
}
