package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DebitTransactionTest {
        DebitTransaction debitTransaction;
    @Before
    public void setUp() {
        debitTransaction = new DebitTransaction(10000, 8999,"IBACO");
    }

    @Test
    public void shouldSubtractFromBalance() {
        assertThat(debitTransaction.transact(),is(1001.0));
    }

    @Test
    public void checkDate() {
        Date date=new Date();
        DebitTransaction debitTrans = new DebitTransaction(date,1000, 1000,"SBI");
        assertTrue(debitTrans.getDate().equals(date));
    }

    @Test
    public void checkDebitedToWhom() {
        assertThat(debitTransaction.toWhom(),is("IBACO"));
    }
}
