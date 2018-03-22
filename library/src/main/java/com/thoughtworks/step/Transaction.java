package com.thoughtworks.step;

import java.util.Date;

public abstract class Transaction {

    private final double balanceBefore,amount,balanceAfter;
    private final Date date;

    public Transaction(Date date, double balanceBefore, double amount, double balanceAfter) {
        this.date=date;
        this.balanceBefore = balanceBefore;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public double transact() {
        return balanceAfter;
    }

    public Date getDate() {
        return date;
    }
}
