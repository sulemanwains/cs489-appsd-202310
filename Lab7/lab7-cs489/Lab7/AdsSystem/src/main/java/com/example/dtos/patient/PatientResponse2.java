package com.example.dtos.patient;

import com.example.dtos.address.AddressResponse;

import java.time.LocalDate;

public record PatientResponse2(long id, String firtsName, String lastName, String email, String contact, LocalDate dob, String mailAddress ) {

}
