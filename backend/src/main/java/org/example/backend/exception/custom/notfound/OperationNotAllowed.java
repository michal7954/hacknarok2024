package org.example.backend.exception.custom.notfound;

public class OperationNotAllowed extends RuntimeException {
    public OperationNotAllowed(final String message) {
        super(message);
    }
}
