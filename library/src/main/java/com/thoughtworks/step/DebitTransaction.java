package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction{

    private String debitedTo;

    public DebitTransaction(Date date, double balance, double amount, String debitedTo) {
        super(date,balance,amount,balance-amount);
        this.debitedTo = debitedTo;
    }

    public DebitTransaction(double balance, double amount, String debitedTo) {
        this(new Date(), balance, amount,debitedTo);
        this.debitedTo=debitedTo;
    }

    public String toWhom() {
        return this.debitedTo;
    }
}
