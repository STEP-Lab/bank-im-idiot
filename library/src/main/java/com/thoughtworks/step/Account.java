package com.thoughtworks.step;

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
        transactions.credit(balance,amount, "SBI HYD");
        return balance=balance+amount;
    }

    public double debit(double amount) throws InsufficientFundsException {
        double remainingBalance=balance-amount;
        if(minimumBalance>remainingBalance) throw new InsufficientFundsException();
        transactions.debit(balance,amount,"WB");
        return balance=remainingBalance;
    }
}
