package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TransactionsTest {
        Transactions transactions;
    @Before
    public void setUp() {
        transactions = new Transactions();
    }

    @Test
    public void checkTransactions() {
        CreditTransaction trans = new CreditTransaction(new Date(),1,1);
        assertTrue(transactions.addTransaction(trans));
        assertTrue(transactions.getRecentTransaction().equals(trans));
    }

    @Test
    public void checkDebitTransaction() {
        DebitTransaction transaction = new DebitTransaction(new Date(),1000,5000);
        assertTrue(transactions.addTransaction(transaction));
        assertTrue(transactions.getRecentTransaction().equals(transaction));
    }
}
