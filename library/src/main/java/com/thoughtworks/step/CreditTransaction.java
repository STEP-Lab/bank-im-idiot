package com.thoughtworks.step;

import java.util.Date;

public class CreditTransaction extends Transaction{

    public CreditTransaction(Date date, double balance, double amount) {
        super(date,balance,amount,balance+amount);
    }
}
