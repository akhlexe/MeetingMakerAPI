package com.exepinero.MeetingMakerAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControlDeExcepciones {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(value = HttpMessageNotReadableException.class)
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    public ErrorResponse handleUnprocessableEntityException(HttpMessageNotReadableException msgNotReadble){
//
//        // note that we've added new properties (message, status) to our ErrorResponse model
//        return ErrorResponse.builder().errorMessage("UNPROCESSABLE INPUT DATA")
//                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
//                .build();
//
//    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {

        List<ErrorModel> errores = exception.getBindingResult().getFieldErrors().stream()
                .map(err -> new ErrorModel(err.getField(), err.getRejectedValue(), err.getDefaultMessage()))
                .distinct()
                .collect(Collectors.toList());

        return ErrorResponse.builder().errorMessage(errores).build();
    }
}




















