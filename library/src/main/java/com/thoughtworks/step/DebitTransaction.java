package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction{

    public DebitTransaction(Date date, double balance, double amount, String debitedTo) {
        super(date,balance,amount,debitedTo);
    }

    public DebitTransaction(double balance, double amount, String debitedTo) {
        this(new Date(), balance, amount,debitedTo);
    }

}
