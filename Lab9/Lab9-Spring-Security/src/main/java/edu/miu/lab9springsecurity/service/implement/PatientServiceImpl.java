package edu.miu.lab9springsecurity.service.implement;

import edu.miu.lab9springsecurity.dto.AddressResponse;
import edu.miu.lab9springsecurity.dto.PatientResponse;
import edu.miu.lab9springsecurity.models.Patient;
import edu.miu.lab9springsecurity.repository.AddressRepository;
import edu.miu.lab9springsecurity.repository.PatientRepository;
import edu.miu.lab9springsecurity.service.PatientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;
    AddressRepository addressRepository;

    public PatientServiceImpl(PatientRepository patientRepository, AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<PatientResponse> getAllPatients() {

        return patientRepository.findAll(Sort.by("firstName"))
                .stream()
                .map(p -> new PatientResponse(p.getPatientNo(),
                        p.getFirstName(),
                        p.getLastName(),
                        new AddressResponse(p.getAddress().getStreet(),
                                p.getAddress().getCity(),
                                p.getAddress().getState(),
                                p.getAddress().getZipCode())))
                .toList();
    }

    @Override
    public Patient addNewPatient(Patient newPatient) {

        return patientRepository.save(newPatient);
    }

    @Override
    public Patient getPatientById(Integer patientId) {

        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public Patient updatePatientById(Integer patientId, Patient editedPatient) {
        var patient = patientRepository.findById(patientId).orElse(null);
        if(patient != null) {
            patient.setPatientNo(editedPatient.getPatientNo());
            patient.setFirstName(editedPatient.getFirstName());
            patient.setLastName(editedPatient.getLastName());
            var address = patient.getAddress();
            address.setStreet(editedPatient.getAddress().getStreet());
            address.setCity(editedPatient.getAddress().getCity());
            address.setState(editedPatient.getAddress().getState());
            address.setZipCode(editedPatient.getAddress().getZipCode());
            return patientRepository.save(patient);
        }else {
            return null;
        }
    }

    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public List<Patient> searchPatient(String searchString) {
        return patientRepository.findPatientByFirstNameContainingOrLastNameContainingOrAddress_StreetContainingOrAddress_CityContainingOrAddress_StateContaining(
                searchString, searchString, searchString, searchString, searchString
        );
    }


}
