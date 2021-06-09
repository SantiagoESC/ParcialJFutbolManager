package edu.utn.Parcial.Domain;

import edu.utn.Parcial.Domain.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "FRIEND")
public class Friend extends Person {


    private String profession;
    private String statusSocial;

    @Override
    public PersonType PersonType() {
        return PersonType.FRIEND;
    }
}

