package com.anymind.bitcoin.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anymind.bitcoin.dto.InputDateParam;
import com.anymind.bitcoin.dto.TransactionDTO;
import com.anymind.bitcoin.entity.Transaction;
import com.anymind.bitcoin.service.BitCoinService;

/**
 *
 * @author Sony George : mr.sony.george@gmail.com
 */
@RestController
@RequestMapping("/bitcoin")

public class BitCoinController {

    private static final Logger LOG = LoggerFactory.getLogger(BitCoinController.class);

    @Autowired
    private BitCoinService bitCoinService;

    @GetMapping(value = "/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "API to get All BitCoin Transactions", value = "getAllBitCoinTransactions")
    public ResponseEntity<List<Transaction>> getAllBitCoinTransactions() {
        return ResponseEntity.ok(bitCoinService.getAllBitCoinTransactions());
    }

    @GetMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "API to get BitCoin Transaction by id", value = "getBitCoinTransactionById")
    public ResponseEntity<Transaction> getBitCoinTransactionById(@PathVariable(name = "id") Long id) {
        Optional<Transaction> existingTransaction = bitCoinService.getBitCoinTransactionById(id);
        if (existingTransaction.isPresent()) {
            return ResponseEntity.ok(existingTransaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/v1/by-name/{coinName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "another example of selecting the object using field", value = "getBitCoinTransactionByCoinName")
    public ResponseEntity<List<Transaction>> getBitCoinTransactionByCoinName(@PathVariable(name = "coinName") String coinName) {
        return ResponseEntity.ok(bitCoinService.getBitCoinTransactionByCoinName(coinName));
    }

    @GetMapping(value = "/v1/by-date/{fromdate}/{todate}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "GET method API to get BitCoin Transactions based on date, GET Method", value = "getBitCoinTransactionsHourlyBasedOnDate1")
    public ResponseEntity<List<TransactionDTO>> getBitCoinTransactionsHourlyBasedOnDate1(
            @ApiParam(name = "fromdate", allowEmptyValue = false, required = true, format = "yyyy-MM-dd'T'HH:mm:ss", example = "2022-02-01T00:00:00")
            @PathVariable(name = "fromdate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fromDate,
            @ApiParam(name = "todate", allowEmptyValue = false, required = true, format = "yyyy-MM-dd'T'HH:mm:ss", example = "2022-02-27T23:59:00")
            @PathVariable(name = "todate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime toDate) {
        LOG.debug("fromDate value from parameter is :{}", fromDate);
        LOG.debug("toDate value from parameter   is :{}", toDate);
        InputDateParam inputDateParam = new InputDateParam();
        inputDateParam.setFromDate(fromDate);
        inputDateParam.setToDate(toDate);
        return ResponseEntity.ok(bitCoinService.getBitCoinTransactionsHourlyBased(inputDateParam));
    }

    @GetMapping(value = "/v1/by-hour-balance/{fromdate}/{todate}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "GET method API to get BitCoin Transactions based on date using incremental balance of BTC every hour", value = "getBitCoinTransactionsHourlyBasedOnDate1")
    public ResponseEntity<List<TransactionDTO>> getBitCoinTransactionsHourlyBalanceIncremental1(
            @ApiParam(name = "fromdate", allowEmptyValue = false, required = true, format = "yyyy-MM-dd'T'HH:mm:ss", example = "2022-02-01T00:00:00")
            @PathVariable(name = "fromdate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fromDate,
            @ApiParam(name = "todate", allowEmptyValue = false, required = true, format = "yyyy-MM-dd'T'HH:mm:ss", example = "2022-02-27T23:59:00")
            @PathVariable(name = "todate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime toDate) {
        LOG.debug("fromDate value from parameter is :{}", fromDate);
        LOG.debug("toDate value from parameter   is :{}", toDate);
        InputDateParam inputDateParam = new InputDateParam();
        inputDateParam.setFromDate(fromDate);
        inputDateParam.setToDate(toDate);
        return ResponseEntity.ok(bitCoinService.getBitCoinTransactionsHourlyBalanceIncremental(inputDateParam));
    }

    @PostMapping(value = "/v1/by-date", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "Alternative POST method for GET API of '/v1/by-date/{fromdate}/{todate}'", value = "getBitCoinTransactionsHourlyBasedOnDate2")
    public ResponseEntity<List<TransactionDTO>> getBitCoinTransactionsHourlyBasedOnDate2(@Valid @RequestBody InputDateParam inputDateParam) {
        LOG.debug("inputDateParam object is :{}", inputDateParam);
        return ResponseEntity.ok(bitCoinService.getBitCoinTransactionsHourlyBased(inputDateParam));
    }

    @PostMapping(value = "/v1/by-hour-balance", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "Alternative POST method for GET API of '/v1/by-hour-balance/{fromdate}/{todate}', using incremental balance of BTC every hour", value = "getBitCoinTransactionsHourlyBasedOnDate2")
    public ResponseEntity<List<TransactionDTO>> getBitCoinTransactionsHourlyBalanceIncremental2(@Valid @RequestBody InputDateParam inputDateParam) {
        LOG.debug("inputDateParam object is :{}", inputDateParam);
        return ResponseEntity.ok(bitCoinService.getBitCoinTransactionsHourlyBalanceIncremental(inputDateParam));
    }

    @PostMapping(value = "/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "POST API to save the BitCoin Transaction'", value = "saveBitCoinTransaction")
    public ResponseEntity<Transaction> saveBitCoinTransaction(@Valid @RequestBody Transaction transaction) {
        return ResponseEntity.ok(bitCoinService.saveBitCoinTransaction(transaction));
    }

    @PutMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "PUT API to update the BitCoin Transaction  id value must be present, if not new object is created'", value = "updateBitCoinTransaction")
    public ResponseEntity<Transaction> updateBitCoinTransaction(@Valid @PathVariable(name = "id") Long id, @Valid @RequestBody Transaction transaction) {
        Optional<Transaction> existingTransaction = bitCoinService.getBitCoinTransactionById(id);
        if (existingTransaction.isPresent()) {
            Transaction existingTrans = existingTransaction.get();
            existingTrans.setCoinName(transaction.getCoinName());
            existingTrans.setAmount(transaction.getAmount());
            existingTrans.setDatetime(transaction.getDatetime());
            return ResponseEntity.ok(bitCoinService.updateBitCoinTransaction(existingTrans));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "DELETE API to delete the BitCoin Transaction'", value = "deleteBitCoinTransaction")
    public ResponseEntity<?> deleteBitCoinTransactionById(@Valid @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(bitCoinService.deleteBitCoinTransactionById(id));
    }
}
