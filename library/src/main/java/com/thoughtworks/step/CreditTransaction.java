package com.thoughtworks.step;

import java.util.Date;

public class CreditTransaction extends Transaction{

    public CreditTransaction(Date date, double balance, double amount, String creditedFrom) {
        super(date,balance,amount,creditedFrom);
    }

    public CreditTransaction(double balance, double amount, String creditedFrom) {
        this(new Date(),balance,amount,creditedFrom);
    }

}
