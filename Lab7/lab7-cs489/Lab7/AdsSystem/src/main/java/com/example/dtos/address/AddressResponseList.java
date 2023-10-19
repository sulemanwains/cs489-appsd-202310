package com.example.dtos.address;

import com.example.dtos.patient.PatientResponse;
import com.example.dtos.patient.PatientResponse2;
import com.example.entity.Patient;

public record AddressResponseList(
        long addressId,
        String street,
        String city,
        String zipCode,
        PatientResponse2 patient
) {

}
