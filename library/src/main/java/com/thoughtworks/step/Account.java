package com.thoughtworks.step;

import java.util.Date;

public class Account {
    private final String name;
    private final AccountNumber accountNumber;
    private final Transactions transactions;
    private double balance;
    private final double minimumBalance=1000;

    public Account(String name, AccountNumber accountNumber, double balance) throws MinimumBalanceException{
        this.name = name;
        this.accountNumber = accountNumber;
        validateMinimumBalance(balance);
        this.balance=balance;
        this.transactions=new Transactions();
    }

    private void validateMinimumBalance(double balance) throws MinimumBalanceException {
        if(balance<minimumBalance) throw new MinimumBalanceException();
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double credit(double amount) {
        return balance=transactions.credit(new Date(), balance,amount);
    }

    public double debit(double amount) throws InsufficientFundsException {
        DebitTransaction trans= new DebitTransaction(new Date(), balance,amount);
        double remainingBalance=trans.transact();
        if(minimumBalance>remainingBalance) throw new InsufficientFundsException();
     //transactions.addTransaction(trans);
        return balance=remainingBalance;
    }
}
