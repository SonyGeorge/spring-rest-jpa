package com.anymind.bitcoin.dto;

import java.math.BigDecimal;

/**
 *
 * @author Sony George : mr.sony.george@gmail.com example class for
 * Interface-based DTO projections
 */
public interface TransactionDTO {

    public BigDecimal getAmount();

    public String getDatetime();

    public void setAmount(BigDecimal amount);

    public void setDatetime(String datetime);
}
