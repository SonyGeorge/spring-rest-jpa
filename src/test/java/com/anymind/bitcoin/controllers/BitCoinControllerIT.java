package com.anymind.bitcoin.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.anymind.bitcoin.BaseTestClass;
import com.anymind.bitcoin.TransactionDTOImpl;
import com.anymind.bitcoin.dto.InputDateParam;
import com.anymind.bitcoin.entity.Transaction;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sonyg
 */
public class BitCoinControllerIT extends BaseTestClass {

    public BitCoinControllerIT() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllBitCoinTransactions method, of class BitCoinController.
     */
    @Test
    @Order(1)
    public void testGetAllBitCoinTransactions() {
        System.out.println("getAllBitCoinTransactions test started !!!");

        assertNotNull(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/bitcoin/v1/", Transaction[].class));
        System.out.println("getAllBitCoinTransactions test completed ###");
    }

    /**
     * Test of getBitCoinTransactionById method, of class BitCoinController.
     */
    @Test
    @Order(2)
    public void testGetBitCoinTransactionById() {
        System.out.println("getBitCoinTransactionById test started !!!");
        Long id = null;
        assertNotNull(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/bitcoin/v1/1", Transaction.class));
        System.out.println("getBitCoinTransactionById test completed ###");
    }

    /**
     * Test of getBitCoinTransactionByCoinName method, of class
     * BitCoinController.
     */
    @Test
    @Order(3)
    public void testGetBitCoinTransactionByCoinName() {
        System.out.println("getBitCoinTransactionByCoinName test started !!!");
        String coinName = "BTC";
        assertNotNull(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/bitcoin/v1/by-name/" + coinName, Transaction[].class));
        System.out.println("getBitCoinTransactionByCoinName test completed ###");
    }

    /**
     * Test of getBitCoinTransactionsHourlyBasedOnDate1 method, of class
     * BitCoinController.
     */
    @Test
    @Order(4)
    public void testGetBitCoinTransactionsHourlyBasedOnDate1() {
        System.out.println("getBitCoinTransactionsHourlyBasedOnDate1 test started !!!");
        LocalDateTime fromDate = LocalDateTime.of(2022, Month.FEBRUARY, 01, 00, 00, 00);
        LocalDateTime toDate = LocalDateTime.of(2022, Month.FEBRUARY, 27, 23, 59, 00);
        System.out.println(fromDate.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(toDate.format(DateTimeFormatter.ISO_DATE_TIME));
        assertNotNull(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/bitcoin/v1/by-date/" + fromDate.format(DateTimeFormatter.ISO_DATE_TIME) + "/" + toDate.format(DateTimeFormatter.ISO_DATE_TIME), TransactionDTOImpl[].class));
        System.out.println("getBitCoinTransactionsHourlyBasedOnDate1 test completed ###");
    }

    /**
     * Test of getBitCoinTransactionsHourlyBalanceIncremental1 method, of class
     * BitCoinController.
     */
    @Test
    @Order(5)
    public void getBitCoinTransactionsHourlyBalanceIncremental1() {
        System.out.println("getBitCoinTransactionsHourlyBalanceIncremental1 test started !!!");
        LocalDateTime fromDate = LocalDateTime.of(2022, Month.FEBRUARY, 01, 00, 00, 00);
        LocalDateTime toDate = LocalDateTime.of(2022, Month.FEBRUARY, 27, 23, 59, 00);
        System.out.println(fromDate.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(toDate.format(DateTimeFormatter.ISO_DATE_TIME));
        assertNotNull(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/bitcoin/v1/by-hour-balance/" + fromDate.format(DateTimeFormatter.ISO_DATE_TIME) + "/" + toDate.format(DateTimeFormatter.ISO_DATE_TIME), TransactionDTOImpl[].class));
        System.out.println("getBitCoinTransactionsHourlyBalanceIncremental1 test completed ###");
    }

    /**
     * Test of getBitCoinTransactionsHourlyBasedOnDate2 method, of class
     * BitCoinController.
     */
    @Test
    @Order(6)
    public void testGetBitCoinTransactionsHourlyBasedOnDate2() {
        System.out.println("getBitCoinTransactionsHourlyBasedOnDate2 test started !!!");
        InputDateParam inputDates = new InputDateParam();
        inputDates.setFromDate(LocalDateTime.of(2022, Month.FEBRUARY, 01, 00, 00, 00));
        inputDates.setToDate(LocalDateTime.of(2022, Month.FEBRUARY, 27, 23, 59, 00));
        assertNotNull(
                this.restTemplate
                        .postForEntity("http://localhost:" + port + "/bitcoin/v1/by-date/", inputDates, TransactionDTOImpl[].class));
        System.out.println("getBitCoinTransactionsHourlyBasedOnDate2 test completed ###");
    }
    /**
     * Test of getBitCoinTransactionsHourlyBalanceIncremental2 method, of class
     * BitCoinController.
     */
    @Test
    @Order(7)
    public void getBitCoinTransactionsHourlyBalanceIncremental2() {
        System.out.println("getBitCoinTransactionsHourlyBalanceIncremental2 test started !!!");
        InputDateParam inputDates = new InputDateParam();
        inputDates.setFromDate(LocalDateTime.of(2022, Month.FEBRUARY, 01, 00, 00, 00));
        inputDates.setToDate(LocalDateTime.of(2022, Month.FEBRUARY, 27, 23, 59, 00));
        assertNotNull(
                this.restTemplate
                        .postForEntity("http://localhost:" + port + "/bitcoin/v1/by-hour-balance/", inputDates, TransactionDTOImpl[].class));
        System.out.println("getBitCoinTransactionsHourlyBalanceIncremental2 test completed ###");
    }

    /**
     * Test of saveBitCoinTransaction method, of class BitCoinController.
     */
    @Test
    @Order(8)
    public void testSaveBitCoinTransaction() {
        System.out.println("saveBitCoinTransaction test started !!!");
        Transaction transaction = new Transaction();
        transaction.setCoinName("BTC");
        transaction.setAmount(random(35));
        transaction.setDatetime(Instant.now());
        assertNotNull(
                this.restTemplate
                        .postForEntity("http://localhost:" + port + "/bitcoin/v1/", transaction, Transaction.class));
        System.out.println("saveBitCoinTransaction test completed ###");
    }

    /**
     * Test of updateBitCoinTransaction method, of class BitCoinController.
     */
    @Test
    @Order(9)
    public void testUpdateBitCoinTransaction() {
        System.out.println("updateBitCoinTransaction test started !!!");
        Transaction transaction = new Transaction();
        transaction.setCoinName("BTC");
        transaction.setAmount(random(35));
        transaction.setDatetime(Instant.now());
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(transaction, headers);
        assertNotNull(
                this.restTemplate.exchange("http://localhost:" + port + "/bitcoin/v1/1", HttpMethod.PUT, entity, Transaction.class));
        System.out.println("updateBitCoinTransaction test completed ###");
    }

    /**
     * Test of deleteBitCoinTransaction method, of class BitCoinController.
     */
    @Test
    @Order(10)
    public void deleteBitCoinTransactionById() {
        System.out.println("deleteBitCoinTransaction test started !!!");
        Transaction transaction = new Transaction();
        transaction.setCoinName("BTC");
        transaction.setAmount(random(35));
        transaction.setDatetime(Instant.now());
        ResponseEntity<Transaction> existing = this.restTemplate
                .postForEntity("http://localhost:" + port + "/bitcoin/v1/", transaction, Transaction.class);
        this.restTemplate
                .delete("http://localhost:" + port + "/bitcoin/v1/" + existing.getBody().getId());
        System.out.println("deleteBitCoinTransaction test completed ###");
    }

    public static BigDecimal random(int range) {
        BigDecimal max = new BigDecimal(range);
        BigDecimal randFromDouble = new BigDecimal(Math.random());
        BigDecimal actualRandomDec = randFromDouble.multiply(max);
        actualRandomDec = actualRandomDec
                .setScale(2, RoundingMode.DOWN);
        return actualRandomDec;
    }
}
