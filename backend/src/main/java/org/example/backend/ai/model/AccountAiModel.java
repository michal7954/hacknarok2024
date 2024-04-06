package org.example.backend.ai.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import org.example.backend.db.Account;

public interface AccountAiModel {
    @JsonClassDescription("Use it to check who im and what age i am")
    record Request(Long accountId) {
    }
    record Response(Account account) {
    }
}
