package com.anymind.bitcoin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anymind.bitcoin.dto.TransactionDTO;
import com.anymind.bitcoin.entity.Transaction;

/**
 *
 * @author Sony George : mr.sony.george@gmail.com
 */
@Repository
public interface BitCoinRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> getTransactionsByCoinName(@Param("coinName") String coinName);

    // native query is used in this method to showcase that, JPA can use both JPA query and native query as well
    @Query(value = "SELECT SUM(amount)as amount,DATE_FORMAT(date_time, '%Y-%m-%dT%H:00:00')as datetime  FROM transactions WHERE  "
            + " date_time BETWEEN STR_TO_DATE(?1,'%Y-%m-%dT%H:%i:%s') AND STR_TO_DATE(?2,'%Y-%m-%dT%H:%i:%s') "
            + " GROUP BY hour( date_time ) , day( date_time ) ,MONTH(date_time) ORDER BY 2 ", nativeQuery = true)
    public List<TransactionDTO> getBitCoinTransactionsHourlyBased(String fromDate, String toDate);
}
