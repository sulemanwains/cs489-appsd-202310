package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    private List<Appointments> appointments;
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
