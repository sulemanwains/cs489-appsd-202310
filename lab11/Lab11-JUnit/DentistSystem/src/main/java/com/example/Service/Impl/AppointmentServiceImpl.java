package com.example.Service.Impl;

import com.example.Service.AppointmentService;
import com.example.entity.Appointments;

import com.example.repo.AppointmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    AppointmentsRepo appointmentsRepo;
    @Autowired
    AppointmentServiceImpl(AppointmentsRepo appointmentsRepo){
        this.appointmentsRepo = appointmentsRepo;
    }
    @Override
    public void addNewAppointment(Appointments appointments) {
        appointmentsRepo.save(appointments);
    }

    @Override
    public List<Appointments> findByDentistName(String name) {
        return appointmentsRepo.findByDentistFirstName(name);
    }
}
