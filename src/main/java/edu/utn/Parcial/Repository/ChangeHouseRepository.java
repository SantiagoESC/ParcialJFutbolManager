package edu.utn.Parcial.Repository;

import edu.utn.Parcial.Domain.ChangeHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeHouseRepository extends JpaRepository<ChangeHouse, Long>, JpaSpecificationExecutor<ChangeHouse> {

}