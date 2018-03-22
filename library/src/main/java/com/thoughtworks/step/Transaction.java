package com.thoughtworks.step;

public class Transaction {

    private final double balanceBefore,amount,balanceAfter;

    public Transaction(double balanceBefore, double amount, double balanceAfter) {
        this.balanceBefore = balanceBefore;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public double getBalanceBefore() {
        return balanceBefore;
    }

    public double transact() {
        return balanceAfter;
    }

    public double getTransactingAmount() {
        return amount;
    }
}
