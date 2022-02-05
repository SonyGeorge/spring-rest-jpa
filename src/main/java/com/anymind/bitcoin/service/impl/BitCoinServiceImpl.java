package com.anymind.bitcoin.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anymind.bitcoin.dto.InputDateParam;
import com.anymind.bitcoin.dto.TransactionDTO;
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
    public Optional<Transaction> getBitCoinTransactionById(Long id) {
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

    @Override
    public List<TransactionDTO> getBitCoinTransactionsHourlyBased(InputDateParam inputDateParam) {
        LOG.debug("from date is :{}", inputDateParam.getFromDate().format(DateTimeFormatter.ISO_DATE_TIME));
        LOG.debug("to date is   :{}", inputDateParam.getToDate().format(DateTimeFormatter.ISO_DATE_TIME));
        return bitCoinRepository.getBitCoinTransactionsHourlyBased(inputDateParam.getFromDate().format(DateTimeFormatter.ISO_DATE_TIME), inputDateParam.getToDate().format(DateTimeFormatter.ISO_DATE_TIME));
    }

    /**
     * Total Bitcoin earned very hour, incremented to every hour
     */
    @Override
    public List<TransactionDTO> getBitCoinTransactionsHourlyBalanceIncremental(InputDateParam inputDateParam) {
        List<TransactionDTO> hourGroupBtc = getBitCoinTransactionsHourlyBased(inputDateParam);
        List<TransactionDTO> incrementalBalanceBtc = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (TransactionDTO hourlyValue : hourGroupBtc) {
            TransactionDTO incrementalBalance = new TransactionDTO() {
                private BigDecimal amount;
                private String datetime;

                @Override
                public BigDecimal getAmount() {
                    return amount;
                }

                @Override
                public String getDatetime() {
                    return datetime;
                }

                @Override
                public void setAmount(BigDecimal amount) {
                    this.amount = amount;
                }

                @Override
                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            };
            total = total.add(hourlyValue.getAmount());
            incrementalBalance.setAmount(total);
            incrementalBalance.setDatetime(hourlyValue.getDatetime());

            incrementalBalanceBtc.add(incrementalBalance);
        }

        return incrementalBalanceBtc;
    }

}
