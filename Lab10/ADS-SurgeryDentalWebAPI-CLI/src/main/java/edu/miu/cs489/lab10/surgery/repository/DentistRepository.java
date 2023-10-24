package edu.miu.cs489.lab10.surgery.repository;

import edu.miu.cs489.lab10.surgery.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {

    @Query(value = "select p from Dentist p")
    public List<Dentist> getMyDentist();

    @Query(value = "select p from Dentist p where p.firstName = :firstName")
    public Optional<Dentist> getDentistByName(String firstName);

    @Query(value = "SELECT * FROM `cs-489-apsd-dental`.dentists p where p.firstName like 'Ap%'", nativeQuery = true)
    public Optional<Dentist> getNativeDentistByName(String firstName);

    // Using Query methods
//    public List<Dentist> findDentistByNameIsStartingWith(String starFirstName);
}
