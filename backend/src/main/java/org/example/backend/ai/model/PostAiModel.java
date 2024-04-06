package org.example.backend.ai.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import org.example.backend.Account;

public interface PostAiModel {
    @JsonClassDescription("Use it to check who im and what age i have")
    record Request(Integer accountId) {
    }
    record Response(Account account) {
    }
}
