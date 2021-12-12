package com.exepinero.MeetingMakerAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ManejoDeExcepciones {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception){

        Map<String, String > errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(err -> {

            String field = ((FieldError) err).getField();
            String message = err.getDefaultMessage();
            errors.put(field,message);
        });

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }


}
