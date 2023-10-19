package com.example.Service.Impl;

import com.example.Service.PatientService;
import com.example.dtos.address.AddressResponse;
import com.example.dtos.patient.PatientRequest;
import com.example.dtos.patient.PatientResponse;
import com.example.entity.Patient;
import com.example.exceptions.PatientNotFound;
import com.example.mapper.PatientMapper;
import com.example.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;
    @Autowired
    PatientServiceImpl(PatientRepo patientRepo){
        this.patientRepo = patientRepo;
    }


    @Override
    public void addPatient(Patient patient) {
        patientRepo.save(patient);
    }

    @Override
    public PatientResponse findByEmail(String email) throws PatientNotFound {
        return patientRepo.findByEmail(email)
                .map(p->PatientMapper.patientEntityToPatientResponse(p))
                .orElseThrow(()->new PatientNotFound(String.format("ERROR: Patient with email %s not found.", email)));
    }

    @Override
    public PatientResponse findById(long id) throws PatientNotFound {
        return patientRepo.findById(id)
                .map(p->PatientMapper.patientEntityToPatientResponse(p))
                .orElseThrow(()->new PatientNotFound(String.format("ERROR: Patient with id %d not found.", id)));
    }

    @Override
    public List<PatientResponse> getPatients() {
        var patients = patientRepo.findAll(Sort.by("lastName"))
                .stream()
                .map(p->
                        PatientMapper.patientEntityToPatientResponse(p)
                ).toList();
        return  patients;
    }

    @Override
    public PatientResponse addNewPatient(@Valid PatientRequest patient) {
        Patient newPatient = PatientMapper.patientRequestToPatientEntity(patient);
        patientRepo.save(newPatient);

        return PatientMapper.patientEntityToPatientResponse(newPatient);
    }

    @Override
    public PatientResponse updatepatient(Long id, Patient patient) throws PatientNotFound {
        var patientUpdate = patientRepo.findById(id)
                .orElseThrow(()->new PatientNotFound(String.format("ERROR: Patient with id %d not found.", id)));
        var address = patientUpdate.getAddress();

        patientUpdate.setFirstName(patient.getFirstName());
        patientUpdate.setLastName(patient.getLastName());
        patientUpdate.setEmail(patient.getEmail());
        patientUpdate.setContact(patient.getContact());
        patientUpdate.setMailAddress(patient.getMailAddress());
        patientUpdate.setDob(patient.getDob());

        address.setCity(patient.getAddress().getCity());
        address.setStreet(patient.getAddress().getStreet());
        address.setZipcode(patient.getAddress().getZipcode());
        patientUpdate.setAddress(address);

        patientRepo.save(patientUpdate);

        return PatientMapper.patientEntityToPatientResponse(patientUpdate);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepo.deleteById(id);
    }

    @Override
    public List<PatientResponse> searchPatient(String searchString) throws PatientNotFound {

        List<PatientResponse>  patients = patientRepo.findByFirstNameContainingOrLastNameContainingOrContactContainingOrEmailContainingOrMailAddressContainingOrAddressStreetContainingOrAddressCityContainingOrAddressZipcodeContaining(searchString, searchString, searchString, searchString, searchString, searchString, searchString, searchString)
                .stream()
                .map(p-> PatientMapper.patientEntityToPatientResponse(p))
                .toList();

        return patients;
    }
}
