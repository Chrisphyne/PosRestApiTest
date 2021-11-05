package com.posrestapi.posrestapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PosAuthException extends RuntimeException{

    public PosAuthException(String message) {
        super(message);
    }
}
