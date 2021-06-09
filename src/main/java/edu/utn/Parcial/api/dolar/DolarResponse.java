package edu.utn.Parcial.api.dolar;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.utn.Parcial.api.CurrencyConverterResponse;
import lombok.Data;

@Data
public class DolarResponse {

    @JsonProperty("casa")
    private CurrencyConverterResponse currencyConverter;
}