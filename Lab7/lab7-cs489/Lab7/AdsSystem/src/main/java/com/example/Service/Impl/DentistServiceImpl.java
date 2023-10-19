package com.example.Service.Impl;

import com.example.Service.DentistService;
import com.example.entity.Dentist;
import com.example.repo.DentistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepo dentistRepo;
    @Autowired
    DentistServiceImpl(DentistRepo dentistRepo){
        this.dentistRepo = dentistRepo;
    }

    @Override
    public void addDentist(Dentist dentist) {
        dentistRepo.save(dentist);
    }

    @Override
    public List<Dentist> findBySpecialization(String specialization){
        return dentistRepo.findBySpecialization(specialization);
    }


}
