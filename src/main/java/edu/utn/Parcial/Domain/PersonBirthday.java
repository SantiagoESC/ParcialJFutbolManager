package edu.utn.Parcial.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_PERSON", "ID_BIRTHDAY"})})
public class PersonBirthday implements Serializable {


    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PERSON",nullable = false)
    private Person person;

    @Id
    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "ID_BIRTHDAY")
    private Birthday birthday;
}
