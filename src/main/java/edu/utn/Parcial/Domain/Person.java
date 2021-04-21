package edu.utn.Parcial.Domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typePerson",visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Manager.class,name = "MANAGER"),
        @JsonSubTypes.Type(value = Player.class,name = "PLAYER"),
        @JsonSubTypes.Type(value = Friend.class,name = "FRIEND"),

})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Person")
public abstract class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON")
    private Integer idPerson;

    @NotNull(message = "The field name is required")
    @Column(name = "NAME")
    private String name;

    @NotNull(message = "The field weight is required")
    @Column(name = "LAST_NAME")
    private String  lastName;

    @AccessType(AccessType.Type.PROPERTY)
    public  abstract PersonType PersonType();

    @OneToOne
    @JoinColumn(name = "birthdayPerson", referencedColumnName = "ID_BIRTHDAY")
    private Birthday myBirthday;

    @ManyToMany
    private Set<Birthday> birthdayList = new HashSet<>();

}
