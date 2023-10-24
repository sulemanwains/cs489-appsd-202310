package edu.miu.lab9springsecurity.exception;

public class PatientNotFoundException extends Exception{
    public PatientNotFoundException(String message) {
        super(message);
    }
}
