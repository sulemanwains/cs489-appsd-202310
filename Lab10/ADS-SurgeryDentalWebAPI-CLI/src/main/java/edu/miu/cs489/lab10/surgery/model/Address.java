package edu.miu.cs489.lab10.surgery.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column(length = 20)
    private String street;

    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String state;

    @Column(length = 5)
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Surgery surgery;

    @OneToOne(mappedBy = "address")
    private Patient patient;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
