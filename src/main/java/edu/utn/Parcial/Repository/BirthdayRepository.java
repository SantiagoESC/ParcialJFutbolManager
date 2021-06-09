package edu.utn.Parcial.Repository;

import edu.utn.Parcial.Domain.Birthday;
import edu.utn.Parcial.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BirthdayRepository extends JpaRepository<Birthday, Integer> {
    Optional<Birthday> findByBirthdayPerson(Person birthdayPerson);

}
