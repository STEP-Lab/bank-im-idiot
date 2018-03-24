package com.thoughtworks.step;

import java.util.Date;

public class CreditTransaction extends Transaction{

    private String creditedFrom;

    public CreditTransaction(Date date, double balance, double amount, String creditedFrom) {
        super(date,balance,amount,balance+amount);
        this.creditedFrom = creditedFrom;
    }

    public CreditTransaction(double balance, double amount, String creditedFrom) {
        this(new Date(),balance,amount,creditedFrom);
        this.creditedFrom = creditedFrom;
    }

    public String fromWhom() {
        return this.creditedFrom;
    }
}
