package edu.miu.lab7.cs489.service.Impl;

import edu.miu.lab7.cs489.model.Appointment;
import edu.miu.lab7.cs489.repo.AppointmentsRepo;
import edu.miu.lab7.cs489.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    AppointmentsRepo appointmentsRepo;
@Autowired
AppointmentServiceImpl(AppointmentsRepo appointmentsRepo){this.appointmentsRepo =appointmentsRepo;}
    @Override
    public void addNewAppointment(Appointment appointments) {
    appointmentsRepo.save(appointments);
    }

    @Override
    public List<Appointment> findByDentistName(String name) {
        return appointmentsRepo.findByDentistFirstName(name);
    }
}
