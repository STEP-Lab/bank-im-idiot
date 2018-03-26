package com.thoughtworks.step;

import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    private ArrayList<Transaction> log = new ArrayList<>();

    private boolean addTransaction(Transaction trans) {
        return this.log.add(trans);
    }

    public Transaction getRecentTransaction() {
        return this.log.get(this.log.size()-1);
    }

    public void credit(Date date, double balance, double amount) {
        CreditTransaction creditTransaction = new CreditTransaction(date, balance, amount, "SBI IND");
        this.addTransaction(creditTransaction);
    }

    public void debit(Date date, double balance, double amount) {
        DebitTransaction debitTransaction = new DebitTransaction(date, balance, amount, "AXIS B");
        this.addTransaction(debitTransaction);
    }
}
