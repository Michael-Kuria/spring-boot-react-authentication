package com.michael.authentication.exceptions;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String x){
        super(x);
    }
}
