package edu.utn.Parcial.Domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonTypeName("MANAGER")
@Entity(name = "MANAGER")
public class Manager extends Person{

    @NotNull(message = "The field total amount is required")
    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount;

    @NotNull(message = "The field Amount Of The Vault is required")
    @Column(name = "AMOUNT_OF_THE_VAULT")
    private double AmountOfTheVault;

    @OneToMany( mappedBy = "manager")
    private List<Player> listPlayer = new ArrayList<Player>();
}
