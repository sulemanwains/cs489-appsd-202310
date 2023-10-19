package com.example.Service;

import com.example.dtos.patient.PatientRequest;
import com.example.dtos.patient.PatientResponse;
import com.example.entity.Patient;
import com.example.exceptions.PatientNotFound;

import java.util.List;

public interface PatientService {

   void addPatient(Patient patient);
   PatientResponse findByEmail(String email) throws PatientNotFound;
   PatientResponse findById(long id) throws PatientNotFound;

   List<PatientResponse> getPatients();

   PatientResponse addNewPatient(PatientRequest patient);

   PatientResponse updatepatient(Long id, Patient patient) throws PatientNotFound;

   void deletePatientById(Long id);
   List<PatientResponse> searchPatient(String searchString) throws PatientNotFound;
}
