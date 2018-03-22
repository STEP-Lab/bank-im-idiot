package com.thoughtworks.step;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void checkingProperties() {
        Transaction trans = new Transaction(1000,1000,2000);
        assertThat(trans.getBalanceBefore(),is(1000.0));
        assertThat(trans.transact(),is(2000.0));
        assertThat(trans.getTransactingAmount(),is(1000.0));
    }
}