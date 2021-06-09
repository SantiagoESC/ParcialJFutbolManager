package edu.utn.Parcial.Domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDTO {

    public String nameComplete;
    public String currency;
    public String amount;


}
