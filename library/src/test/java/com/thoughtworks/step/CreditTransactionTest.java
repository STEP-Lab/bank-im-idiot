package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CreditTransactionTest {
        CreditTransaction creditTrans;

    @Before
    public void setUp() {
        creditTrans = new CreditTransaction(new Date(),1000, 1000, "IND");
    }

    @Test
    public void checkDate() {
        Date date=new Date();
        CreditTransaction creditTrans = new CreditTransaction(date,1000, 1000, "IND");
        assertTrue(creditTrans.getDate().equals(date));
    }

    @Test
    public void checkCreditedFromWhom() {
        assertThat(creditTrans.fromWhom(),is("IND"));
    }
}
