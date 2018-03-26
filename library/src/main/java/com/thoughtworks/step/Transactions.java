package com.thoughtworks.step;

import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    protected ArrayList<Transaction> log = new ArrayList<>();

    private boolean addTransaction(Transaction trans) {
        return this.log.add(trans);
    }

    public void credit(double balance, double amount, String source) {
        CreditTransaction creditTransaction = new CreditTransaction(new Date(), balance, amount,source);
        this.addTransaction(creditTransaction);
    }

    public void debit(double balance, double amount, String source) {
        DebitTransaction debitTransaction = new DebitTransaction(new Date(), balance, amount, source);
        this.addTransaction(debitTransaction);
    }

    public Transactions filterByAmountGreaterThan(double amount) {
        Transactions transactions = new Transactions();
        for(Transaction transaction : log){
             if(transaction.getAmount()>=amount){
                 transactions.addTransaction(transaction);
             }
        }
        return transactions;
    }

    public Transactions filterByAmountLesserThan(double amount) {
        Transactions transactions = new Transactions();
        for(Transaction transaction : log){
            if(transaction.getAmount()<amount) transactions.addTransaction(transaction);
        }
        return transactions;
    }

    public Transactions filterCreditTransactions() {
        Transactions transactions = new Transactions();
        for (Transaction transaction: log) {
            if (transaction.getClass().equals(CreditTransaction.class)){
                transactions.addTransaction(transaction);
            }
        }
        return transactions;
    }

    public Transactions filterDebitTransactions() {
        Transactions transactions = new Transactions();
        for (Transaction transaction: log) {
            if (transaction.getClass().equals(DebitTransaction.class)){
                transactions.addTransaction(transaction);
            }
        }
        return transactions;
    }
}
