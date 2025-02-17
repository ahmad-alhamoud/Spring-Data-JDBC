package com.dev.ahmad.jdbc.controller;

import com.dev.ahmad.jdbc.model.Post;
import com.dev.ahmad.jdbc.model.dto.PostDetails;
import com.dev.ahmad.jdbc.repository.AuthorRepository;
import com.dev.ahmad.jdbc.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostController(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @GetMapping("{id}")
    public Post findById(@PathVariable Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @GetMapping("{id}/details")
    public PostDetails getPostDetails(@PathVariable Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        Integer authorId = post.getAuthor().getId();
        return new PostDetails(post, authorRepository.findById(authorId).orElse(null));
    }
}
