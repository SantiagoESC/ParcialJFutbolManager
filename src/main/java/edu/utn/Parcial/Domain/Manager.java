package edu.utn.Parcial.Domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.utn.Parcial.Domain.enums.PersonType;
import edu.utn.Parcial.Domain.enums.TypeCurrency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonTypeName("MANAGER")
@Entity(name = "MANAGER")
public class Manager extends Person{

    //@NotNull(message = "The field total amount is required")
    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount;

    //@NotNull(message = "The field Amount Of The Vault is required")
    @Column(name = "AMOUNT_OF_THE_VAULT")
    private Float vaultWeight;

    @OneToMany( mappedBy = "manager")
    private List<Player> listPlayer = new ArrayList<Player>();

    @Override
    public PersonType PersonType() {
        return PersonType.MANAGER;
    }

    //Refresh the amount total.Each bill weighs 1 gram
    public void refreshWeight(Float weight){
        this.vaultWeight = this.vaultWeight + weight;
    }

    //Refresh the total depending on whether it is in ars or in dollars or in euros.
    public void refreshTotalAmount(double amount, String typeCurrency){
        //this.totalAmount = CurrencyUtils.convertToPesos()
        this.totalAmount = typeCurrency.equals(TypeCurrency.EUROS)  ? this.totalAmount + amount * 100 :
                typeCurrency.equals(TypeCurrency.DOLLAR) ? this.totalAmount + amount * 200 :
                        this.totalAmount + amount;

    }

    //Find a player in the list.
    public Optional<Player> findPlayer (Integer id){
        return this.listPlayer.stream().filter(q -> q.getIdPerson() == id).findAny();
    }
}
