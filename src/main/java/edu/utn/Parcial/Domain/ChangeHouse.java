package edu.utn.Parcial.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CHANGE_HOUSE")
public class ChangeHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "AMOUNT")
    private Integer amount;

    @OneToOne
    @JoinColumn(name="ID_PERSON", referencedColumnName = "ID_PERSON",nullable=false)
    private Player player;

}