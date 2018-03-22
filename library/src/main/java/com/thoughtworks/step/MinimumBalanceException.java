package com.thoughtworks.step;

public class MinimumBalanceException extends Throwable {

    public MinimumBalanceException() {
        super("Balance should be minimum ₹1000");
    }

}
