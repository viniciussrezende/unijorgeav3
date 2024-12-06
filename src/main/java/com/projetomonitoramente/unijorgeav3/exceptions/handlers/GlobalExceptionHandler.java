package com.projetomonitoramente.unijorgeav3.exceptions.handlers;


import com.projetomonitoramente.unijorgeav3.exceptions.device.DeviceCreationException;
import com.projetomonitoramente.unijorgeav3.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DeviceCreationException.class)
    public ResponseEntity<ErrorResponse> handleDeviceCreationException(DeviceCreationException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                "Device Creation Error",
                exception.getMessage()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                "Validation Error",
                "Please correct the following fields as indicated in 'mapError'."
        );

        Map<String, String> mapError = new HashMap<>();
        for (FieldError fieldError : exception.getFieldErrors()){
            mapError.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        errorResponse.setMapError(mapError);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
