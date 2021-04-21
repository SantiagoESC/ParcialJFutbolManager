package edu.utn.Parcial.Exception;

import javassist.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handlerConstraintViolation(ConstraintViolationException ex, WebRequest request){

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getHttpStatus());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object>errorNotFoundExceptionHandler(final NotFoundException ex, WebRequest request){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> runTimeException(final RuntimeException r, WebRequest request){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,r.getLocalizedMessage());
        return new ResponseEntity<Object>(apiError, new HttpHeaders(),apiError.getHttpStatus());
    }
}
