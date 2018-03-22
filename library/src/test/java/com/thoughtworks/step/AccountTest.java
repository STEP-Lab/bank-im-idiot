package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account("dhana", "1234-1234",1000);
    }

    @Test
    public void checkAccountNumber() {
        assertThat(account.getAccountNumber(),is("1234-1234"));
    }

    @Test
    public void checkName() {
        assertThat(account.getName(),is("dhana"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("dhana", "1234-1234",100);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void validateAccountNumber() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("Peter","1234-123",1000);
    }
}
