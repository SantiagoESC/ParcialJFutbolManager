package edu.utn.Parcial.Domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonTypeName("CURRENCY")
@Entity(name = "CURRENCY")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURRENCY")
    private Integer idCurrency;

    @Column(name = "CURRENCY")
    private String currency;

    /*@Column(name = "AMOUNT")
    private Float  amount;
*/
    @Column(name = "AMOUNT")
    @Digits(integer=9,fraction=0)
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name="ID_PERSON", referencedColumnName = "ID_PERSON",nullable=false)
    private Player player;
}
