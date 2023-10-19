package com.example.mapper;

import com.example.dtos.address.AddressResponse;
import com.example.dtos.patient.PatientRequest;
import com.example.dtos.patient.PatientResponse;
import com.example.entity.Address;
import com.example.entity.Patient;

public class PatientMapper {

    public static Patient patientRequestToPatientEntity(PatientRequest patientRequest){
        Patient patient = new Patient(patientRequest.firtsName(), patientRequest.lastName(), patientRequest.email(), patientRequest.contact(), patientRequest.mailAddress(),
                new Address(
                        patientRequest.address().city(),
                        patientRequest.address().street(),
                        patientRequest.address().zipcode()
                ));
        return patient;
    }

    public static PatientResponse patientEntityToPatientResponse(Patient patient){
        return new PatientResponse(patient.getId(), patient.getFirstName(), patient.getLastName(),
                patient.getEmail(), patient.getMailAddress(), new AddressResponse(patient.getAddress().getCity(), patient.getAddress().getStreet(), patient.getAddress().getZipcode()));

    }
}
