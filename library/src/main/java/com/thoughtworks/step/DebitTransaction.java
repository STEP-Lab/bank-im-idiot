package com.thoughtworks.step;

public class DebitTransaction extends Transaction{

    public DebitTransaction(double balance, double amount) {
        super(balance,amount,balance-amount);
    }
}
