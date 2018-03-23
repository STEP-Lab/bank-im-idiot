package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        AccountNumber accNum = new AccountNumber("1234-1234");
        account = new Account("dhana", accNum,1000);
    }


    @Test
    public void checkName() {
        assertThat(account.getName(),is("dhana"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        AccountNumber accountNumber = new AccountNumber("1234-1212");
        new Account("dhana", accountNumber,100);
    }

    @Test
    public void testCredit() {
        assertThat(account.credit(1000),is(2000.0));
    }

    @Test
    public void testDebit() throws InsufficientFundsException {
        account.credit(1000);
        assertThat(account.debit(100),is(1900.0));
    }

    @Test
    public void checkAccountNumber() throws InvalidAccountNumberException, MinimumBalanceException {
        AccountNumber accNumber= new AccountNumber("1234-1002");
        Account account= new Account("T\'chala",accNumber,100000);
        assertTrue(account.getAccountNumber().equals(accNumber));
    }
    @Test(expected = InsufficientFundsException.class)
    public void CheckInsufficentFunds() throws MinimumBalanceException, InvalidAccountNumberException, InsufficientFundsException {
        AccountNumber accountNumber = new AccountNumber("1212-0000");
        Account acc=new Account("Tony Stark",accountNumber,20000);
        acc.debit(100000);
    }
}
