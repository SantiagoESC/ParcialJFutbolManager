package edu.utn.Parcial.Domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type",visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Manager.class,name = "MANAGER"),
        @JsonSubTypes.Type(value = Player.class,name = "PLAYER")
})

@NoArgsConstructor
@Entity
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
}
