package com.anymind.bitcoin.dto;

import lombok.Data;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

/**
 *
 * @author sonyg
 */
@Data
public class InputDateParam {

    @NotNull
    private LocalDateTime fromDate;
    @NotNull
    private LocalDateTime toDate;

}
