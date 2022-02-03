package com.anymind.bitcoin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anymind.bitcoin.entity.Transaction;

/**
 *
 * @author Sony George : mr.sony.george@gmail.com
 */
@Repository
public interface BitCoinRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> getTransactionsByCoinName(@Param("coinName") String coinName);
}
