package edu.miu.lab9springsecurity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    @ManyToOne
    @JoinColumn
    private Dentist dentist;
    @ManyToOne
    @JoinColumn
    private Patient patient;
    @ManyToOne
    @JoinColumn
    private Surgery surgery;
}
