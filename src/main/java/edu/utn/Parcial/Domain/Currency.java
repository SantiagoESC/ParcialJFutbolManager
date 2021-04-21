package edu.utn.Parcial.Domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonTypeName("currency")
@Entity(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURRENCY")
    private Integer idCurrency;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "AMOUNT")
    private Float  amount;


    @OneToOne
    @JoinColumn(name="ID_PERSON", referencedColumnName = "ID_PERSON",nullable=false)
    private Player player;
}
