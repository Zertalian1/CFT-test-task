package com.example.cfttest.controllers;

import com.example.cfttest.exeption.ProductsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProductsException.class)
    public ResponseEntity<?> handleServiceException(ProductsException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
