package edu.miu.cs489.lab10.surgery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointDate;
    private LocalDate appointTime;

    @ManyToOne
    @JoinColumn(name = "patientId", unique = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "surgeryId", unique = false)
    private Surgery surgery;

    @ManyToOne
    @JoinColumn(name = "dentistId", unique = false)
    private Dentist dentist;

}
