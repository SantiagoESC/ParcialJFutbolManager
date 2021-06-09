package edu.utn.Parcial.Domain.dto.response;

import edu.utn.Parcial.Domain.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CurrencyResponseDTO {

    private Long id;

    private Currency currency;

    private BigDecimal amount;

}