package com.thoughtworks.step;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    @Test
    public void checkAccountNumber() {
        Account account = new Account("dhana", "1234-1234");
        assertThat(account.getAccountNumber(),is("1234-1234"));
    }
}
