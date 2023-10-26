package com.example.exceptions;

public class PatientNotFound extends Exception{

    public PatientNotFound(String message){
        super(message);
    }
}
