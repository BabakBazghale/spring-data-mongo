package com.bob.projects.mongo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateDataException extends RuntimeException {

    public DuplicateDataException(String message) {
        super(message);
    }
}
