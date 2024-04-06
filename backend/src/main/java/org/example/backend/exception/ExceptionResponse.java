package org.example.backend.exception;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class ExceptionResponse {
    private final LocalDateTime localDateTime;
    private final String message;

    public ExceptionResponse(String message) {
        this.localDateTime = LocalDateTime.now(ZoneId.of("UTC"));
        this.message = message;
    }
}
