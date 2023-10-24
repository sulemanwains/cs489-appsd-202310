package edu.miu.cs489.lab10.surgery.repository;

import edu.miu.cs489.lab10.surgery.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
