package com.example.dtos.patient;

import com.example.dtos.address.AddressResponse;

public record PatientResponse(long id, String firtsName, String lastName, String email, String mailAddress, AddressResponse address ) {

}
