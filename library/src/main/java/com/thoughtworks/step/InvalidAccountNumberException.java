package com.thoughtworks.step;

public class InvalidAccountNumberException extends Throwable {
    public InvalidAccountNumberException() {
        super("Invalid AccountNumber or Format. ex.'0000-0000' ");
    }
}
