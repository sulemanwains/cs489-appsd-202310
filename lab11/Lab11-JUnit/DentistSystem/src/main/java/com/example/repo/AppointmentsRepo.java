package com.example.repo;

import com.example.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentsRepo extends JpaRepository<Appointments, Long> {
    List<Appointments> findByDentistFirstName(String name);
}
