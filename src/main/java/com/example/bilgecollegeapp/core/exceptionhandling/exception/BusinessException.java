package com.example.bilgecollegeapp.core.exceptionhandling.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
