package edu.utn.Parcial.Domain.dto.request;


import edu.utn.Parcial.Domain.Currency;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CurrencyRequestDTO {

    @NotBlank
    private Currency currency;

    @NotNull
    @Digits(integer=10, fraction=0)
    private BigDecimal amount;

}
