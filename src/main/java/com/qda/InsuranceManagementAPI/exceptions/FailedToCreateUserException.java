package com.qda.InsuranceManagementAPI.exceptions;

public class FailedToCreateUserException extends RuntimeException {
    public FailedToCreateUserException(String message) {
        super(message);
    }
}
