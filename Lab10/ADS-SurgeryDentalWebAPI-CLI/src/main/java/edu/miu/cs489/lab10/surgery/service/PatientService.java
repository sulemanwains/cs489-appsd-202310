package edu.miu.cs489.lab10.surgery.service;

import edu.miu.cs489.lab10.surgery.dto.patient.PatientRequest;
import edu.miu.cs489.lab10.surgery.dto.patient.PatientResponse;
import edu.miu.cs489.lab10.surgery.exception.PatientNotFoundException;

import java.util.List;

public interface PatientService {

    List<PatientResponse> getAllPatients();

    PatientResponse addNewPatient(PatientRequest newPatient);

    PatientResponse getPatientById(int patientId) throws PatientNotFoundException;

    PatientResponse updatePatientById(PatientRequest patientRequest, int patientId) throws PatientNotFoundException;

    void deletePatientById(int patientId) throws PatientNotFoundException;
}
