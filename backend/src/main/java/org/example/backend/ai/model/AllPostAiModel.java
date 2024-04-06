package org.example.backend.ai.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import org.example.backend.db.Post;

import java.util.List;

public interface AllPostAiModel {
    @JsonClassDescription("Use it to retrieve all the posts")
    record Request() {
    }
    record Response(List<Post> posts) {
    }
}
