package com.desafio.ecommerce.exceptions;

public class EmailValidationException extends RuntimeException{

    public EmailValidationException(String message){
        super(message);
    }
}

