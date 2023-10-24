package edu.miu.cs489.lab10.surgery.dto.patient;


import edu.miu.cs489.lab10.surgery.dto.address.AddressResponse;

import java.time.LocalDate;

public record PatientResponse(

        Integer patientId,

        String fistName,

        String lastName,

        String phoneNumber,

        String email,

        LocalDate dob,

        AddressResponse primaryAddress
) {

}
