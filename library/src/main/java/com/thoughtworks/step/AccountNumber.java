package com.thoughtworks.step;

public class AccountNumber {
    private String accountNumber;

    public AccountNumber(String accountNumber) throws InvalidAccountNumberException {
        validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
    }

    private void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if(!accountNumber.matches("\\d{4}-\\d{4}")) throw new InvalidAccountNumberException();
    }
}
