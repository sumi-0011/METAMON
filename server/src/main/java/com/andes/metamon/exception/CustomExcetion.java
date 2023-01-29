package com.andes.metamon.exception;

import lombok.Getter;

@Getter
public class CustomExcetion extends RuntimeException{
    private final BaseResponseStatusCode errorCode;

    public CustomExcetion(String message, final BaseResponseStatusCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
