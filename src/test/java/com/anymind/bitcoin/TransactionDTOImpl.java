/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anymind.bitcoin;

import java.math.BigDecimal;

import com.anymind.bitcoin.dto.TransactionDTO;

/**
 *
 * @author sonyg
 */
public class TransactionDTOImpl implements TransactionDTO {

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

}
