package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction{

    public DebitTransaction(Date date, double balance, double amount) {

        super(date,balance,amount,balance-amount);
    }
}
