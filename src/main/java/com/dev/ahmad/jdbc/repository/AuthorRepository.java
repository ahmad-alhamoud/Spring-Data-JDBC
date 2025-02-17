package com.dev.ahmad.jdbc.repository;

import com.dev.ahmad.jdbc.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
