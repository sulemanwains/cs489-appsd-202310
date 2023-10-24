package edu.miu.lab9springsecurity.service;

import edu.miu.lab9springsecurity.dto.PatientResponse;
import edu.miu.lab9springsecurity.models.Patient;

import java.util.List;

public interface PatientService {
    List<PatientResponse> getAllPatients();

    Patient addNewPatient(Patient newPatient);

    Patient getPatientById(Integer patientId);

    Patient updatePatientById(Integer patientId, Patient editedPatient);

    void deletePatientById(Integer patientId);

    List<Patient> searchPatient(String searchString);
}
