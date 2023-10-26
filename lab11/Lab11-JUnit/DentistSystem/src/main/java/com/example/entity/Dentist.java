package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String specialization;
    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    private List<Appointments> appointments;

    public Dentist(String firstName, String lastname, String contact, String email, String specialization){
        this.firstName=firstName;
        this.lastName = lastname;
        this.contact = contact;
        this.email = email;
        this.specialization = specialization;
    }


}
