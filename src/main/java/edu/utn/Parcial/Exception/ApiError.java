package edu.utn.Parcial.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class ApiError {

    private HttpStatus httpStatus;
    private String message;
}