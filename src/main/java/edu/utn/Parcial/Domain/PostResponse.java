package edu.utn.Parcial.Domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class PostResponse {

    private String url;
    private HttpStatus status;
    private ResponseEntity resonseEntity;


}