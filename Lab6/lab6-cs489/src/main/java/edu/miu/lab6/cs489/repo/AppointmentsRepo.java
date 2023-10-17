package edu.miu.lab6.cs489.repo;

import edu.miu.lab6.cs489.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AppointmentsRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDentistFirstName(String name);
}
