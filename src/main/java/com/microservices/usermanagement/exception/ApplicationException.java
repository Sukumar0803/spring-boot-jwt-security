package com.microservices.usermanagement.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends  RuntimeException{

    private final String typeId;

    public ApplicationException(String message, String typeId) {
        super(message);
        this.typeId = typeId;
    }


}
