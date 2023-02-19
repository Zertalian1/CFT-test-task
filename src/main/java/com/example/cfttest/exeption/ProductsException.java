package com.example.cfttest.exeption;

public class ProductsException extends RuntimeException{

    public ProductsException(){
        super("Undescribed error");
    }

    public ProductsException(String text){
        super(text);
    }

}
