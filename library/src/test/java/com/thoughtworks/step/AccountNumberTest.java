package com.thoughtworks.step;

import org.junit.Test;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void validateAccountNumber() throws InvalidAccountNumberException {
        new AccountNumber("1234");
    }
}
