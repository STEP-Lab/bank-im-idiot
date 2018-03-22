package com.thoughtworks.step;

public class Account {
    private final String name,accountNumber;
    private final Transactions transactions;
    private double balance;
    private final double minimumBalance=1000;

    public Account(String name, String accountNumber,double balance) throws MinimumBalanceException, InvalidAccountNumberException {
        this.name = name;
        validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        validateMinimumBalance(balance);
        this.balance=balance;
        this.transactions=new Transactions();
    }

    private void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if(!accountNumber.matches("\\d{4}-\\d{4}")) throw new InvalidAccountNumberException();
    }

    private void validateMinimumBalance(double balance) throws MinimumBalanceException {
        if(balance<minimumBalance) throw new MinimumBalanceException();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double credit(double amount) {
        CreditTransaction trans=new CreditTransaction(balance,amount);
        transactions.addTransaction(trans);
        return balance=trans.transact();
    }

    public double debit(double amount) throws InsufficientFundsException {
        DebitTransaction trans= new DebitTransaction(balance,amount);
        double remainingBalance=trans.transact();
        if(minimumBalance>remainingBalance) throw new InsufficientFundsException();
        transactions.addTransaction(trans);
        return balance=remainingBalance;
    }
}
