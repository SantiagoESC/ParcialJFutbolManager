package edu.utn.Parcial.Repository;

import edu.utn.Parcial.Domain.Person;
import edu.utn.Parcial.Domain.projections.PersonProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {

    PersonProjection findByName(String name);

}
