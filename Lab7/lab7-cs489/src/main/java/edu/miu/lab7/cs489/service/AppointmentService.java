package edu.miu.lab7.cs489.service;

import edu.miu.lab7.cs489.model.Appointment;

import java.util.List;

public interface AppointmentService {
    void addNewAppointment(Appointment appointments);
    List<Appointment> findByDentistName(String name);
}
