package edu.utn.Parcial.Utils;

import edu.utn.Parcial.Domain.enums.TypeCurrency;

import java.math.BigDecimal;

public class CurrencyUtils {

    private static final BigDecimal DOLLER_TO_PESOS = BigDecimal.valueOf(150.5);
    private static final BigDecimal EURO_TO_PESOS = BigDecimal.valueOf(170.5);

    public  static BigDecimal convertToPesos(TypeCurrency typeCurrency,BigDecimal amount) throws Exception {
        BigDecimal result = BigDecimal.ZERO;
        if(typeCurrency.EUROS.equals(typeCurrency)){
            result = amount.multiply(EURO_TO_PESOS);
        }else if(typeCurrency.DOLLAR.equals(typeCurrency)){
            result =amount.multiply(DOLLER_TO_PESOS);
        }else {
            throw new Exception("Type Currency invalid");
        }
        return result;
    }
}
