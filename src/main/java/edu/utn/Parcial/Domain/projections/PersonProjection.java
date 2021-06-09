package edu.utn.Parcial.Domain.projections;

import org.springframework.beans.factory.annotation.Value;

public interface PersonProjection {

    String getNombre();
    String getApellido();

    @Value("#{target.nombre + '  ' + target.apellido}")
    String getFull();


}
