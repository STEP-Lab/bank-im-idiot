package com.thoughtworks.step;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TransactionsTest {
    @Test
    public void checkTransactions() {
        Transactions transactions = new Transactions();
        Transaction trans = new Transaction(1,1,2);
        assertTrue(transactions.addTransaction(trans));
        assertTrue(transactions.getRecentTransaction().equals(trans));
    }
}
