package edu.miu.lab7.cs489.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String street;
    private String city;
    @Column(length = 16)
    private String zipcode;

    public Address(String street, String city, String zipcode){
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

}
