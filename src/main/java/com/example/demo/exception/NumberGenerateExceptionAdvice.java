package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NumberGenerateExceptionAdvice {

    @ExceptionHandler(NumberGenerateException.class)
    public ResponseEntity<?> VerificationTokenNotFoundHandler(NumberGenerateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

