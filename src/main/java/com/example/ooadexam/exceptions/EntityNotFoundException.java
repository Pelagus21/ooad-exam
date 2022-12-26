package com.example.ooadexam.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityName, String property) {
        super("Entity " + entityName + " not found by " + property);
    }

}
