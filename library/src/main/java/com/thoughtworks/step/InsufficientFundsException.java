package com.thoughtworks.step;

public class InsufficientFundsException extends Throwable {
    public InsufficientFundsException() {
        super("Insufficient Funds. Minimum balance should be ₹1000");
    }
}
