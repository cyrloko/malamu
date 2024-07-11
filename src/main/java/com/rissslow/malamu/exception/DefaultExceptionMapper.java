package com.rissslow.malamu.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<DefaultException> {
    @Override
    public Response toResponse(DefaultException exception) {
        return Response.status(exception.getCode())
                .entity(exception.getMessage())
                .build();
    }
}
