package edu.utn.Parcial.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Birthday")
public class Birthday {

    @Id
    @Column(name = "ID_BIRTHDAY")
    private Integer idBirthday;

    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "idPerson", referencedColumnName = "ID_PERSON")
    private Person birthdayPerson;

    //Max 10
    @ManyToMany
    private Set<Person> guestsList = new HashSet<>();

}
