package com.example.mapper;

import com.example.dtos.address.AddressResponse;
import com.example.dtos.address.AddressResponseList;
import com.example.dtos.patient.PatientRequest;
import com.example.dtos.patient.PatientResponse;
import com.example.dtos.patient.PatientResponse2;
import com.example.entity.Address;
import com.example.entity.Patient;

public class AddressMapper {
    public static AddressResponseList addressEntityToAddressResponse(Address address){
        return new AddressResponseList(
                address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getZipcode(),
                address.getPatient()!=null ? (
                new PatientResponse2(
                        address.getPatient().getId(),
                        address.getPatient().getFirstName(),
                        address.getPatient().getLastName(),
                        address.getPatient().getEmail(),
                        address.getPatient().getContact(),
                        address.getPatient().getDob(),
                        address.getPatient().getMailAddress()
                )
                ) : null
        );

    }
}
