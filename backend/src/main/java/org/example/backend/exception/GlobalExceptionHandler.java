package org.example.backend.exception;


import org.example.backend.exception.custom.notfound.AccountNotFoundException;
import org.example.backend.exception.custom.notfound.AccountNotRecognizedException;
import org.example.backend.exception.custom.notfound.PostNotFound;
import org.example.backend.exception.custom.notfound.OperationNotAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({AccountNotFoundException.class})
    ResponseEntity<ExceptionResponse> handleRuntimeException(AccountNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AccountNotRecognizedException.class})
    ResponseEntity<ExceptionResponse> handleRuntimeException(AccountNotRecognizedException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({PostNotFound.class})
    ResponseEntity<ExceptionResponse> handleRuntimeException(PostNotFound ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({OperationNotAllowed.class})
    ResponseEntity<ExceptionResponse> handleRuntimeException(OperationNotAllowed ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
