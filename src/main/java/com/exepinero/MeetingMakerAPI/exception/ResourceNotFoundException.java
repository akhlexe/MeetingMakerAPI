package com.exepinero.MeetingMakerAPI.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends Exception{

    private HttpStatus httpStatus;

    public ResourceNotFoundException(String message) {
        super(message);
        httpStatus = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }
}
