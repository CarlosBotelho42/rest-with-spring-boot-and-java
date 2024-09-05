package com.example.rest_with_spring_boot_and_java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperatorException extends RuntimeException{


    public UnsupportedMathOperatorException(String ex) {
        super(ex);
    }
}
