package edu.utn.Parcial.Repository;

import edu.utn.Parcial.Domain.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<Birthday, Integer> {
}
