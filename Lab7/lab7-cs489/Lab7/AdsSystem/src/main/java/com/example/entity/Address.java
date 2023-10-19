package com.example.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String street;
    private String city;
    @Column(length = 16)
    private String zipcode;

    @OneToOne(mappedBy = "address")
    Patient patient;

    public Address(String street, String city, String zipcode){
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }


}
