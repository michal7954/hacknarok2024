package org.example.backend.ai.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;

public interface IWasWrongAiModel {
    @JsonClassDescription("Use this endpoint to get a response with lessons where i can improve my posts in the future")
    record Request(String input) {

    }

    @JsonClassDescription("Response with lessons where i can improve my posts in the future")
    record Response(String response) {
    }
}
