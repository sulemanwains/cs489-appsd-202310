package edu.miu.lab7.cs489.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String mailAddress;
    private LocalDate dob;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    public Patient(String firstName, String lastname, String contact, String email, String mailAddress, Address address){
        this.firstName = firstName;
        this.lastName = lastname;
        this.contact = contact;
        this.email = email;
        this.mailAddress = mailAddress;
        this.address = address;
    }



}
