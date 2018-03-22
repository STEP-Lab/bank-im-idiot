package com.thoughtworks.step;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DebitTransactionTest {
    @Test
    public void shouldSubtractFromBalance() {
        DebitTransaction debitTransaction = new DebitTransaction(new Date(),10000, 8999);
        assertThat(debitTransaction.transact(),is(1001.0));
    }

    @Test
    public void checkDate() {
        Date date=new Date();
        DebitTransaction debitTrans = new DebitTransaction(date,1000, 1000);
        assertTrue(debitTrans.getDate().equals(date));
    }
}
