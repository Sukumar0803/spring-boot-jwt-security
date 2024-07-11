package com.microservices.usermanagement.exception;

import lombok.Getter;

@Getter
public class UserAlreadyExistException extends RuntimeException {

    private final String typeId;

    public UserAlreadyExistException(String message, String typeId) {
        super(message);
        this.typeId = typeId;
    }
}
