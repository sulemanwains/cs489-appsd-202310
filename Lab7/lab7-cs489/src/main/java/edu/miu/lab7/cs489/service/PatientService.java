package edu.miu.lab7.cs489.service;

import edu.miu.lab7.cs489.model.Patient;

public interface PatientService {

    void addPatient(Patient patient);
    Patient findByEmail(String email);
}
