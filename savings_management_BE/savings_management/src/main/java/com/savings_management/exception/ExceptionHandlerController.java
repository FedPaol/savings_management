package com.savings_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = HttpClientErrorException.BadRequest.class)
    public ResponseEntity<Object> handleBadRequestException(Exception exception) {
        String errorMessage = exception.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
