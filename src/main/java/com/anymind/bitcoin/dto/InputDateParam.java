package com.anymind.bitcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Sony George : mr.sony.george@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDateParam implements Serializable{

    @NotNull
    private LocalDateTime fromDate;
    @NotNull
    private LocalDateTime toDate;

}
