package com.example.repo;

import com.example.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Publisher;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);

    List<Patient> findByFirstNameContainingOrLastNameContainingOrContactContainingOrEmailContainingOrMailAddressContainingOrAddressStreetContainingOrAddressCityContainingOrAddressZipcodeContaining(String searchString1, String searchString2, String searchString3, String searchString4, String searchString5, String searchString6, String searchString7, String searchString8);
}
