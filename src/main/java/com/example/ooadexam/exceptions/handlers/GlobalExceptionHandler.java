package com.example.ooadexam.exceptions.handlers;

import com.example.ooadexam.exceptions.EntityNotFoundException;
import com.example.ooadexam.exceptions.UserBlockedException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder str = new StringBuilder();
        for (ConstraintViolation<?> violation : e.getConstraintViolations())
            str.append(violation.getMessage()).append('\n');
        return new ResponseEntity<>(this.getErrorResponseBody(str.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(this.getErrorResponseBody(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UserBlockedException.class})
    public ResponseEntity<Map<String, String>> handleUserBlockedException(UserBlockedException e) {
        return new ResponseEntity<>(this.getErrorResponseBody(e.getMessage()), HttpStatus.FORBIDDEN);
    }

    private Map<String, String> getErrorResponseBody(String errorMsg) {
        Map<String, String> map = new HashMap<>();
        map.put("success", "false");
        map.put("error", errorMsg);
        return map;
    }
}
