package com.jungle.springbootmyboard.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
