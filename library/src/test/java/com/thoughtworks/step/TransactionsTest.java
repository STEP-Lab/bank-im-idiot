package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
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
        transactions.credit(balance,amount, "INSD");
        CreditTransaction trans = new CreditTransaction(balance,amount, "INSD");
        assertThat(transactions.log, hasItem(trans));
    }

    @Test
    public void checkForDebitTransactions() {
        double balance=10000,amount=50000;
        transactions.debit(balance,amount, "BAJAJ");
        DebitTransaction trans = new DebitTransaction(balance,amount,"BAJAJ");
        assertThat(transactions.log,hasItem(trans));
    }

    @Test
    public void checkBothCreditAndDebit() {
        double balance=1000,amount=50000;
        transactions.credit(balance,amount,"IND");
        CreditTransaction creditTrans = new CreditTransaction(balance,amount, "IND");
        transactions.debit(balance,amount,"VEN" );
        DebitTransaction debitTrans = new DebitTransaction(balance,amount,"VEN");
        assertThat(transactions.log,hasItems(creditTrans,debitTrans));
    }

    @Test
    public void checkFilterTransactionsAboveASpecificAmount() {
        transactions.credit(1000,15000,"IND");
        transactions.debit(20000,15000,"VEN" );
        transactions.debit(5000,1500,"VEN" );
        CreditTransaction creditTrans = new CreditTransaction(1000,15000, "IND");
        DebitTransaction debitTrans = new DebitTransaction(20000,15000,"VEN");
        Transactions filteredTransactions=transactions.filterByAmountGreaterThan(10000);
        assertThat(filteredTransactions.log,hasItems(creditTrans,debitTrans));
    }

    @Test
    public void checkFilterTransactionsBelowASpecificAmount() {
        transactions.credit(1000,1500,"IND");
        transactions.debit(20000,150,"VEN" );
        transactions.debit(5000,10,"VEN" );
        CreditTransaction creditTrans = new CreditTransaction(1000,1500, "IND");
        DebitTransaction debitTrans = new DebitTransaction(20000,150,"VEN");
        Transactions filteredTransactions=transactions.filterByAmountLesserThan(2000);
        assertThat(filteredTransactions.log,hasItems(creditTrans,debitTrans));
    }

    @Test
    public void checkFilteredCreditTransaction() {
        transactions.credit(1000,1500,"IND");
        transactions.credit(2500,15000,"VEN");
        transactions.debit(5000,100,"VEN" );
        CreditTransaction creditTrans,creditTransaction;
        creditTrans = new CreditTransaction(1000,1500, "IND");
        creditTransaction = new CreditTransaction(1000,1500, "IND");
        assertThat(transactions.filterCreditTransactions().log,hasItems(creditTrans,creditTransaction));
    }

    @Test
    public void checkFilteredDebitTransaction() {
        transactions.debit(1000,1500,"IND");
        transactions.credit(5000,100,"VEN" );
        transactions.debit(2500,15000,"VEN");
        DebitTransaction debitTrans,debitTransaction;
        debitTrans = new DebitTransaction(1000,1500, "IND");
        debitTransaction = new DebitTransaction(2500,15000, "VEN");
        assertThat(transactions.filterDebitTransactions().log,hasItems(debitTrans,debitTransaction));
    }

    @Test
    public void checkTransactionsBefore() {
        transactions.debit(1000,1500,"IND");
        transactions.debit(2500,15000,"VEN");
        transactions.credit(5000,100,"VEN" );
        DebitTransaction debitTrans,debitTransaction;
        debitTrans = new DebitTransaction(1000,1500, "IND");
        debitTransaction = new DebitTransaction(2500,15000, "VEN");
        CreditTransaction creditTransaction=new CreditTransaction(5000,100,"VEN");
        ArrayList<Transaction> log=transactions.transactionsBefore(new Date(2018-1900,11,31)).log;
        assertThat(log,hasItems(debitTrans,debitTransaction,creditTransaction));
    }

    @Test
    public void checkTransactionAfter() {
        transactions.debit(1000,1500,"IND");
        transactions.debit(2500,15000,"VEN");
        transactions.credit(5000,100,"VEN" );
        DebitTransaction debitTrans,debitTransaction;
        debitTrans = new DebitTransaction(1000,1500, "IND");
        debitTransaction = new DebitTransaction(2500,15000, "VEN");
        CreditTransaction creditTransaction=new CreditTransaction(5000,100,"VEN");
        ArrayList<Transaction> log=transactions.transactionsAfter(new Date(2017-1900,11,31)).log;
        assertThat(log,hasItems(debitTrans,debitTransaction,creditTransaction));
    }

    @Test
    public void checkTransactionOnASpecificDate() {
        transactions.debit(1000,1500,"IND");
        transactions.debit(2500,15000,"VEN");
        transactions.credit(5000,100,"VEN" );
        DebitTransaction debitTrans,debitTransaction;
        debitTrans = new DebitTransaction(1000,1500, "IND");
        debitTransaction = new DebitTransaction(2500,15000, "VEN");
        CreditTransaction creditTransaction=new CreditTransaction(5000,100,"VEN");
        assertThat(transactions.transactionsOn(new Date()).log,hasItems(debitTrans,debitTransaction,creditTransaction));
    }

    @Test
    public void checkTransactionInBetweenDates() {
        transactions.debit(1000,1500,"IND");
        transactions.debit(2500,15000,"VEN");
        transactions.credit(5000,100,"VEN" );
        DebitTransaction debitTrans,debitTransaction;
        debitTrans = new DebitTransaction(1000,1500, "IND");
        debitTransaction = new DebitTransaction(2500,15000, "VEN");
        CreditTransaction creditTransaction=new CreditTransaction(5000,100,"VEN");
        Transactions trans=transactions.transactionsBetween(new Date(2018-1900,02,27),new Date(2018-1900,02,29));
        assertThat(trans.log,hasItems(debitTrans,debitTransaction,creditTransaction));
    }
}
