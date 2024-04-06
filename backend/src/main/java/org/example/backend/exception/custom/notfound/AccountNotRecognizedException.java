package org.example.backend.exception.custom.notfound;

public class AccountNotRecognizedException extends RuntimeException {
    public AccountNotRecognizedException(String message) {
        super(message);
    }
}
