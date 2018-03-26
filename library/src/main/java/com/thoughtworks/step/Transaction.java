package com.thoughtworks.step;

import java.util.Date;
import java.util.Objects;

public abstract class Transaction {

    private final double balanceBefore;
    private final double amount;
    private String source;
    private final Date date;

    public Transaction(Date date, double balanceBefore, double amount,String source) {
        this.date=date;
        this.balanceBefore = balanceBefore;
        this.amount = amount;
        this.source = source;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.balanceBefore, balanceBefore) == 0 &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceBefore, amount,source);
    }

    public String getSource() {
        return source;
    }

    public double getAmount() {
        return amount;
    }
}
