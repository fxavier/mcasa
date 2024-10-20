package com.xavier.exceptions;

import java.util.ResourceBundle;
import java.util.UUID;
import java.util.Locale;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class ThrowableMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable exception) {
        String errorId = UUID.randomUUID().toString();
        log.error("errorId[{}]", errorId, exception);
        String defaultErrorMessage = ResourceBundle.getBundle("validation_messages", Locale.getDefault()).getString("System.error");
        ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage(errorId, defaultErrorMessage);
        ErrorResponse errorResponse = new ErrorResponse(errorMessage);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
    }
    
}
