package com.thoughtworks.step;

public class Account {
    private final String name,accountNumber;
    private double balance;
    private final double minimumBalance=1000;

    public Account(String name, String accountNumber,double balance) throws MinimumBalanceException, InvalidAccountNumberException {
        this.name = name;
        validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        validateMinimumBalance(balance);
        this.balance=balance;
    }

    private void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if(!accountNumber.matches("\\d{4}-\\d{4}")){
            throw new InvalidAccountNumberException();
        }
    }

    private void validateMinimumBalance(double balance) throws MinimumBalanceException {
        if(balance<minimumBalance){
            throw new MinimumBalanceException();
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double credit(double amount) {
        return balance+=amount;
    }

    public double debit(double amount) throws InsufficientFundsException {
        if(minimumBalance>balance-amount){
            throw new InsufficientFundsException();
        }
        return balance-=amount;
    }
}
