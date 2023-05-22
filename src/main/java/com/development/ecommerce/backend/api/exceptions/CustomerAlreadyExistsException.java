package com.development.ecommerce.backend.api.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomerAlreadyExistsException extends Exception{
    public CustomerAlreadyExistsException(){}
    public CustomerAlreadyExistsException(String msg){
        super(msg);
    }
}