package edu.miu.lab7.cs489.repo;

import edu.miu.lab7.cs489.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PatientRepo extends JpaRepository<Patient, String> {

    Optional<Patient> findByEmail(String email);
}
