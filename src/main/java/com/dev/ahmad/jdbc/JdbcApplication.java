package com.dev.ahmad.jdbc;

import com.dev.ahmad.jdbc.model.Author;
import com.dev.ahmad.jdbc.model.Comment;
import com.dev.ahmad.jdbc.model.Post;
import com.dev.ahmad.jdbc.repository.AuthorRepository;
import com.dev.ahmad.jdbc.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;


@SpringBootApplication
public class JdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, AuthorRepository authorRepository) {
        return args -> {
            AggregateReference<Author, Integer> author = AggregateReference.to(authorRepository.save(new Author(null, "ahmad", "Dan", "ahmad@gmail.com", "AhmadDan")).id());
            Post post = posts.save(new Post("Leana", "Leana Deep Blog", author));
            post.addComment(new Comment("First comment" , "some content" ));
            posts.save(post);
        };
    }
}
