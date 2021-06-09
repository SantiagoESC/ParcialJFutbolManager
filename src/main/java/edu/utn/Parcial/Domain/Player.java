package edu.utn.Parcial.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.utn.Parcial.Domain.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonTypeName("PLAYER")
@AllArgsConstructor

@NoArgsConstructor
@Data
@Builder
@Entity(name = "PLAYER")
public class Player extends Person{

    @NotNull
    @Column(name = "WEIGHT")
    private Float weight;

    @NotNull
    @Column(name = "HEIGHT")
    private Float height;


    @Column(name = "GOALS")
    private Integer goals;


    @Column(name = "MINUTES_PLAYED")
    private Float minutesPlayed;

    @NotNull
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @OneToOne
    @JoinColumn(name="ID_CURRENCY", referencedColumnName = "ID_CURRENCY",nullable=false)
    public Currency currency;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="ID_PERSON", insertable = false,updatable = false, referencedColumnName = "ID_PERSON",nullable=false)
    private Manager manager;


    @Override
    public PersonType PersonType() {
        return PersonType.PLAYER;
    }
}
