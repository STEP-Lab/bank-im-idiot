package com.thoughtworks.step;

import java.util.Date;
import java.util.Objects;

public abstract class Transaction {

    private final double balanceBefore,amount;
    private final Date date;

    public Transaction(Date date, double balanceBefore, double amount) {
        this.date=date;
        this.balanceBefore = balanceBefore;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public int hashCode() {
        return Objects.hash(balanceBefore, amount);
    }
}
