package edu.miu.lab6.cs489.service;

import edu.miu.lab6.cs489.model.Dentist;

import java.util.List;

public interface DentistService {
    void addDentist(Dentist dentist);
    List<Dentist> findBySpecialization(String specialization);
}
