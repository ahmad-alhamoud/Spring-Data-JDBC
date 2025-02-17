package com.dev.ahmad.jdbc.model.dto;

import com.dev.ahmad.jdbc.model.Author;
import com.dev.ahmad.jdbc.model.Post;

public record PostDetails(Post post, Author author) {
}
