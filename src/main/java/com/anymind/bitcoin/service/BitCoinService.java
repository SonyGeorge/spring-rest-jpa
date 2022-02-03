package com.anymind.bitcoin.service;

import java.util.List;

import com.anymind.bitcoin.entity.Transaction;

/**
 *
 * @author Sony George : mr.sony.george@gmail.com
 */
public interface BitCoinService {

    public List<Transaction> getAllBitCoinTransactions();

    public Transaction getBitCoinTransactionById(Long id);

    public List<Transaction> getBitCoinTransactionByCoinName(String coinName);

    public Transaction saveBitCoinTransaction(Transaction transaction);

    public Transaction updateBitCoinTransaction(Transaction transaction);

    public boolean deleteBitCoinTransaction(Transaction transaction);

    public boolean deleteBitCoinTransactionById(Long id);

}
