package com.example.pagila.exceptions;

public class SakilaException extends Exception{
    public SakilaException(final String message){
        super(message);

    }

    public SakilaException(final String message, final Throwable cause){
        super(message,cause);

    }
}