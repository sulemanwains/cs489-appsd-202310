package com.example;

import com.example.Service.AppointmentService;
import com.example.Service.DentistService;
import com.example.Service.Impl.AppointmentServiceImpl;
import com.example.Service.PatientService;
import com.example.entity.Address;
import com.example.entity.Appointments;
import com.example.entity.Dentist;
import com.example.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdsApplication  {

	 private final AppointmentService appointmentService;
	 private final DentistService dentistService;
	 private final PatientService patientService;
	AdsApplication(AppointmentService appointmentService, DentistService dentistService, PatientService patientService){
		this.appointmentService = appointmentService;
		this.dentistService = dentistService;
		this.patientService = patientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AdsApplication.class, args);
	}

}
