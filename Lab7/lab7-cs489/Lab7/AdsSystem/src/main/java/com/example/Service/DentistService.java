package com.example.Service;

import com.example.entity.Dentist;

import java.util.List;

public interface DentistService {

   void addDentist(Dentist dentist);
   List<Dentist> findBySpecialization(String specialization);

}
