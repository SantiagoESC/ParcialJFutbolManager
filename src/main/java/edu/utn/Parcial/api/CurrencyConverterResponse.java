package edu.utn.Parcial.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyConverterResponse {

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("compra")
    private String buys;

    @JsonProperty("venta")
    private String sale;

}