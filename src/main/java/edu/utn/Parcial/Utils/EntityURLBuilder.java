package edu.utn.Parcial.Utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class EntityURLBuilder {

    public static String buildUrl(final String entity,final Integer id){

        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{entity}/{id}")
                .buildAndExpand(entity, id)
                .toUriString();
    }
}
