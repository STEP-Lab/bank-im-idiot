package com.thoughtworks.step;

public class Account {
    private final String name;
    private final String accountNumber;

    public Account(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
