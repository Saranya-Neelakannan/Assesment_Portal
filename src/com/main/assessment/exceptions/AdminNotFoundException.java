package com.main.assessment.exceptions;

/**
 * AdminNotFoundException
 */
public class AdminNotFoundException extends RuntimeException {

    public AdminNotFoundException(String message) {
        super(message);
    }
}