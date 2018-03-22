package com.thoughtworks.step;

public class CreditTransaction extends Transaction{

    public CreditTransaction(double balance, double amount) {
        super(balance,amount,balance+amount);
    }
}
