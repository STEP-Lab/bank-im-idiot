package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
        Transactions transactions;
    @Before
    public void setUp() {
        transactions = new Transactions();
    }

    @Test
    public void checkForCreditTransactions() {
        double balance=1000,amount=50000;
        transactions.credit(new Date(),balance,amount);
        CreditTransaction trans = new CreditTransaction(balance,amount, "IND");
        assertThat(transactions.getRecentTransaction().hashCode(),is(trans.hashCode()));
    }

    @Test
    public void checkForDebitTransactions() {
        Date date=new Date();
        double balance=10000,amount=50000;
        transactions.debit(date,balance,amount);
        DebitTransaction trans = new DebitTransaction(balance,amount,"BOI");
        assertThat(transactions.getRecentTransaction().hashCode(),is(trans.hashCode()));
    }
}
