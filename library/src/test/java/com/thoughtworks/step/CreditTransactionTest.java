package com.thoughtworks.step;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CreditTransactionTest {
    @Test
    public void shouldAddAmountToBalance() {
        CreditTransaction creditTrans = new CreditTransaction(1000, 1000);
        assertThat(creditTrans.transact(),is(2000.0));
    }
}
