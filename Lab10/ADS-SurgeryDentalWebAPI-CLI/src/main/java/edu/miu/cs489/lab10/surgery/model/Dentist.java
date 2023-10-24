package edu.miu.cs489.lab10.surgery.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;
    private String firstName;
    private String lastName;

    public Dentist(Integer dentistId, String firstName, String lastName) {
        this.dentistId = dentistId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dentist{");
        sb.append("dentistId=").append(dentistId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
