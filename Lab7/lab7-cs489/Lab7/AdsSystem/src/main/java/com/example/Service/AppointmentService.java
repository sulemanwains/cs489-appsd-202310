package com.example.Service;

import com.example.entity.Appointments;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    void addNewAppointment(Appointments appointments);
    List<Appointments> findByDentistName(String name);
}
