package edu.utn.Parcial.Domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.utn.Parcial.Domain.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Entity(name = "PERSON")
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_x_BIRTHDAY", joinColumns = {
            @JoinColumn(name = "ID_PERSON") }, inverseJoinColumns = {
            @JoinColumn(name = "ID_BIRTHDAY") })
    @Size(min = 0, max = 10)
    private Set<Birthday> birthdayList;

}
