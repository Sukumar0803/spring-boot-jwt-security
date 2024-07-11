package com.microservices.usermanagement.exception;

import lombok.Getter;

@Getter
public class BadCredentialsException extends RuntimeException{

    private final String typeId;

    public BadCredentialsException(String message, String typeId) {
        super(message);
        this.typeId = typeId;
    }
}
