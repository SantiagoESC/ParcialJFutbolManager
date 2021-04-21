package edu.utn.Parcial.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Friend extends Person {


    private String profession;
    private String statusSocial;

    @Override
    public PersonType PersonType() {
        return PersonType.FRIEND;
    }
}

