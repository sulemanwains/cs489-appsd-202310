package edu.miu.lab6.cs489.repo;

import edu.miu.lab6.cs489.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PatientRepo extends JpaRepository<Patient, Long> {

    Optional<Patient> findByEmail(Long email);
}
