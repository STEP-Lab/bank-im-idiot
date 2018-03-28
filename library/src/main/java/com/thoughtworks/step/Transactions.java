package com.thoughtworks.step;

import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    protected ArrayList<Transaction> log = new ArrayList<>();

    private boolean addTransaction(Transaction trans) {
        return this.log.add(trans);
    }

    public void credit(double balance, double amount, String source) {
        CreditTransaction creditTransaction = new CreditTransaction(new Date(), balance, amount, source);
        this.addTransaction(creditTransaction);
    }

    public void debit(double balance, double amount, String source) {
        DebitTransaction debitTransaction = new DebitTransaction(new Date(), balance, amount, source);
        this.addTransaction(debitTransaction);
    }

    public Transactions filterByAmountGreaterThan(double amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction : log) {
            if (transaction.getAmount() >= amount) {
                transactions.addTransaction(transaction);
            }
        }
        return transactions;
    }

    public Transactions filterByAmountLesserThan(double amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction : log) {
            if (transaction.getAmount() < amount) transactions.addTransaction(transaction);
        }
        return transactions;
    }

    public Transactions filterCreditTransactions() {
        Transactions transactions = new Transactions();
        for (Transaction transaction : log) {
            if (transaction.getClass().equals(CreditTransaction.class)) {
                transactions.addTransaction(transaction);
            }
        }
        return transactions;
    }

    public Transactions filterDebitTransactions() {
        Transactions transactions = new Transactions();
        for (Transaction transaction : log) {
            if (transaction.getClass().equals(DebitTransaction.class)) {
                transactions.addTransaction(transaction);
            }
        }
        return transactions;
    }

    public Transactions transactionsBefore(Date date) {
        Transactions transactions = new Transactions();
        for (Transaction transaction : log) {
            System.out.print(transaction.getDate());
            if (transaction.getDate().before(date)) transactions.addTransaction(transaction);
        }
        return transactions;
    }

    public Transactions transactionsAfter(Date date) {
        Transactions transactions = new Transactions();
        for (Transaction transaction : log) {
            if (transaction.getDate().after(date)) transactions.addTransaction(transaction);
        }
        return transactions;
    }

    public Transactions transactionsOn(Date date) {
        Transactions transactions = new Transactions();
        for (Transaction transaction : log) {
            if (transaction.getDate().equals(date)) transactions.addTransaction(transaction);
        }
        return transactions;
    }

    public Transactions transactionsBetween(Date date, Date date1) {
        Transactions transactions = new Transactions();
        for (Transaction transaction : log) {
            if(transaction.getDate().after(date)&&transaction.getDate().before(date1)){
                transactions.addTransaction(transaction);
            }
        }
        return transactions;
    }
}
