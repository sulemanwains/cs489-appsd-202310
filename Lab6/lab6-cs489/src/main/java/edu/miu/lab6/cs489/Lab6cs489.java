package edu.miu.lab6.cs489;

import edu.miu.lab6.cs489.model.Address;
import edu.miu.lab6.cs489.model.Appointment;
import edu.miu.lab6.cs489.model.Dentist;
import edu.miu.lab6.cs489.model.Patient;
import edu.miu.lab6.cs489.service.AppointmentService;
import edu.miu.lab6.cs489.service.DentistService;
import edu.miu.lab6.cs489.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Lab6cs489 implements CommandLineRunner {
    private final AppointmentService appointmentService;
    private final DentistService dentistService;
    private final PatientService patientService;

    public Lab6cs489(AppointmentService appointmentService, DentistService dentistService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab6cs489.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Lab6 - Implementing Data Persistence - SpringBoot");
        List<Appointment> appointments = appointmentService.findByDentistName("John");

        Dentist dentist = new Dentist("Petter", "Kit", "", "testdentist@gmail.com", "Orthodontics" );

        dentistService.addDentist(dentist);

        var orthodontics = dentistService.findBySpecialization("Orthodontics");

        System.out.println(orthodontics.size());

        Patient patient = new Patient("Park", "John", "12313", "park.john@gmail.com", "ABC street MR # 3", new Address("1000 N 4th street", "Fairfield", "52557"));

        patientService.addPatient(patient);

        var park = patientService.findByEmail("park.john@gmail.com");

        System.out.println(park.getFirstName());
    }
}
