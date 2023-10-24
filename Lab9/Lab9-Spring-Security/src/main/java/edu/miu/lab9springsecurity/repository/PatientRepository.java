package edu.miu.lab9springsecurity.repository;

import edu.miu.lab9springsecurity.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public List<Patient> findPatientByFirstNameContainingOrLastNameContainingOrAddress_StreetContainingOrAddress_CityContainingOrAddress_StateContaining(
            String firstName, String lastName, String street, String city, String state);

}
