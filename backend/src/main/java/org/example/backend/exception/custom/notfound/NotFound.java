package org.example.backend.exception.custom.notfound;

public class NotFound  extends RuntimeException {
    public NotFound(final String message) {
        super(message);
    }
}
