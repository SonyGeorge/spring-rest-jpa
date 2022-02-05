package com.anymind.bitcoin.service;

import java.util.List;
import java.util.Optional;

import com.anymind.bitcoin.dto.InputDateParam;
import com.anymind.bitcoin.dto.TransactionDTO;
import com.anymind.bitcoin.entity.Transaction;

/**
 *
 * @author Sony George : mr.sony.george@gmail.com
 */
public interface BitCoinService {

    public List<Transaction> getAllBitCoinTransactions();

    public Optional<Transaction> getBitCoinTransactionById(Long id);

    public List<Transaction> getBitCoinTransactionByCoinName(String coinName);

    public Transaction saveBitCoinTransaction(Transaction transaction);

    public Transaction updateBitCoinTransaction(Transaction transaction);

    public boolean deleteBitCoinTransaction(Transaction transaction);

    public boolean deleteBitCoinTransactionById(Long id);

    public List<TransactionDTO> getBitCoinTransactionsHourlyBased(InputDateParam inputDateParam);

    public List<TransactionDTO> getBitCoinTransactionsHourlyBalanceIncremental(InputDateParam inputDateParam);

}
