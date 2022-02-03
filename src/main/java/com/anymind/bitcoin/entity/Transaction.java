package com.anymind.bitcoin.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Sony George : mr.sony.george@gmail.com
 */
@Entity
@Table(name = "transactions")

@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t "),
    @NamedQuery(name = "Transaction.findByCoinName", query = "SELECT t FROM Transaction t WHERE t.coinName = :coinName")})
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "coin_name")
    private String coinName;
    @NotBlank
    @Column(name = "amount")
    private BigDecimal amount;
    @NotBlank
    @Column(name = "date_time")
    private Instant datetime;
}
