package com.sda.onlinestore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class AuthorException extends RuntimeException{
    public AuthorException(String message){
        super(message);
    }
}
