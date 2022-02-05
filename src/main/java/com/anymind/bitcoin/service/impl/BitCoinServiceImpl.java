package com.anymind.bitcoin.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anymind.bitcoin.entity.Transaction;
import com.anymind.bitcoin.repository.BitCoinRepository;
import com.anymind.bitcoin.service.BitCoinService;
/**
 *
 * @author Sony George : mr.sony.george@gmail.com
 */

@Service
public class BitCoinServiceImpl implements BitCoinService {

    private static final Logger LOG = LoggerFactory.getLogger(BitCoinServiceImpl.class);

    @Autowired
    private BitCoinRepository bitCoinRepository;

    @Override
    public List<Transaction> getAllBitCoinTransactions() {
        return bitCoinRepository.findAll();
    }

    @Override
    public  Optional<Transaction> getBitCoinTransactionById(Long id) {
        return bitCoinRepository.findById(id);
    }

    @Override
    public List<Transaction> getBitCoinTransactionByCoinName(String coinName) {
        return bitCoinRepository.getTransactionsByCoinName(coinName);
    }

    @Override
    public Transaction saveBitCoinTransaction(Transaction transaction) {
        return bitCoinRepository.save(transaction);
    }

    @Override
    public Transaction updateBitCoinTransaction(Transaction transaction) {
        return bitCoinRepository.save(transaction);
    }

    @Override
    public boolean deleteBitCoinTransaction(Transaction transaction) {
        bitCoinRepository.delete(transaction);
        return true;
    }

    @Override
    public boolean deleteBitCoinTransactionById(Long id) {
        bitCoinRepository.deleteById(id);
        return true;
    }

}
