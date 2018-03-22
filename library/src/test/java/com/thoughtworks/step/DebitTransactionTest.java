package com.thoughtworks.step;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DebitTransactionTest {
    @Test
    public void shouldSubtractFromBalance() {
        DebitTransaction debitTransaction = new DebitTransaction(10000, 8999);
        assertThat(debitTransaction.transact(),is(1001.0));
    }
}
