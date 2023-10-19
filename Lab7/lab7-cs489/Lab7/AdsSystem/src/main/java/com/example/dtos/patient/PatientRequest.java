package com.example.dtos.patient;

import com.example.dtos.address.AddressResponse;

import javax.validation.constraints.NotBlank;


public record PatientRequest(
        long id,
        String firtsName,
        String lastName,
        @NotBlank(message = "Patient email is required.")
        String email,
        String contact,
        String mailAddress,
        AddressResponse address ) {

}
