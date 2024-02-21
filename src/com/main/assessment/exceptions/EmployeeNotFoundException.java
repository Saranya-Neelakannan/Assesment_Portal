package com.main.assessment.exceptions;
/**
 * EmployeeNotFoundException
 */
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}