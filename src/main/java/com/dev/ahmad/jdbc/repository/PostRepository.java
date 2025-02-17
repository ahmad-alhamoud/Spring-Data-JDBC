package com.dev.ahmad.jdbc.repository;

import com.dev.ahmad.jdbc.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
