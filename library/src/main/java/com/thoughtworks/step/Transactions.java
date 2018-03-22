package com.thoughtworks.step;

import java.util.ArrayList;

public class Transactions {
    private ArrayList<Transaction> log;

    public Transactions() {
        this.log = new ArrayList<>();
    }

    public boolean addTransaction(Transaction trans) {
        return this.log.add(trans);
    }

    public Object getRecentTransaction() {
        return this.log.get(this.log.size()-1);
    }
}
