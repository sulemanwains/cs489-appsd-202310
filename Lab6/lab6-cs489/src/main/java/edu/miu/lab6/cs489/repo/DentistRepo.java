package edu.miu.lab6.cs489.repo;

import edu.miu.lab6.cs489.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DentistRepo extends JpaRepository<Dentist, Long> {
List<Dentist>findBySpecialization(String specialization);
}
