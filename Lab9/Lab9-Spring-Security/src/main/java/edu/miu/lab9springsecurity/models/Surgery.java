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
@Table(name = "surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surgeryId;
    private String surgeryNo;
    @OneToOne
    @JoinColumn
    private Address surgeryLocation;
    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}
