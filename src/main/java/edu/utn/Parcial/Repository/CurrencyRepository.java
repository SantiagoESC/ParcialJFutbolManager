package edu.utn.Parcial.Repository;

import edu.utn.Parcial.Domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

}
