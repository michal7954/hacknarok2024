package org.example.backend.ai.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import org.example.backend.db.Account;
import org.example.backend.db.Post;

public interface PostAiModel {
    @JsonClassDescription("Use it to retrieve the post")
    record Request(Long postId) {
    }
    record Response(Post post) {
    }
}
