package edu.utn.Parcial.api.euro;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.utn.Parcial.api.CurrencyConverterResponse;

public class EuroResponse {

    @JsonProperty("dolar") //En el json aparece con el nombre dolar
    private CurrencyConverterResponse currencyConverter;

}