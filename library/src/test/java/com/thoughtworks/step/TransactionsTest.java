package com.thoughtworks.step;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TransactionsTest {
    @Test
    public void checkTransactions() {
        Transactions transactions = new Transactions();
        CreditTransaction trans = new CreditTransaction(new Date(),1,1);
        assertTrue(transactions.addTransaction(trans));
        assertTrue(transactions.getRecentTransaction().equals(trans));
    }
}
