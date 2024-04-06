package org.example.backend.exception.custom.notfound;

public class PostNotFound extends RuntimeException {
    public PostNotFound(String message) {
        super(message);
    }

}
