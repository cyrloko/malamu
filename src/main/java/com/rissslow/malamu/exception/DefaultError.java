package com.rissslow.malamu.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.catalina.connector.Response;

@Getter
@AllArgsConstructor
public enum DefaultError {

    ENTITY_NOT_FOUND(new DefaultException(Response.SC_NOT_FOUND, "Resource not found")),

    ENTITY_ALREADY_EXISTS(new DefaultException(Response.SC_CONFLICT, "Resource already exists"));

    private final DefaultException exception;

}
