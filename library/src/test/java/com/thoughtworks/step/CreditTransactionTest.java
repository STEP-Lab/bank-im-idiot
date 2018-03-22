package com.thoughtworks.step;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CreditTransactionTest {
    @Test
    public void shouldAddAmountToBalance() {
        CreditTransaction creditTrans = new CreditTransaction(new Date(),1000, 1000);
        assertThat(creditTrans.transact(),is(2000.0));
    }

    @Test
    public void checkDate() {
        Date date=new Date();
        CreditTransaction creditTrans = new CreditTransaction(date,1000, 1000);
        assertTrue(creditTrans.getDate().equals(date));
    }
}
