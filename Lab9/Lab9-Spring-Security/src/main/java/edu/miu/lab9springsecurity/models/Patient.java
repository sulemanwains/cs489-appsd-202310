package edu.miu.lab9springsecurity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientNo;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn
    //@JsonIgnore
    private Address address;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientNo='" + patientNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address.toString() + '\'' +
                '}';
    }
}
