package edu.miu.lab7.cs489.service.Impl;

import edu.miu.lab7.cs489.model.Patient;
import edu.miu.lab7.cs489.repo.PatientRepo;
import edu.miu.lab7.cs489.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl  implements PatientService {
    private final PatientRepo patientRepo;
    @Autowired
    PatientServiceImpl(PatientRepo patientRepo){
        this.patientRepo = patientRepo;
    }
    @Override
    public void addPatient(Patient patient) {
        patientRepo.save(patient);
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepo.findByEmail(String.valueOf(email)).orElse(new Patient());
    }
}
