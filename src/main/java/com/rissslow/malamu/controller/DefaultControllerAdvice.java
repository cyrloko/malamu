package com.rissslow.malamu.controller;

import com.rissslow.malamu.exception.DefaultException;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log
public class DefaultControllerAdvice {

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity handleDatabaseSearchException(DefaultException exception) {
        log.severe("An error occured");
        return ResponseEntity.status(exception.getCode())
                .body(exception.getMessage());
    }
}
