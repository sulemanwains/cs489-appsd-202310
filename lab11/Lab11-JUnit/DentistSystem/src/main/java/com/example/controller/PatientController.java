package com.example.controller;

import com.example.Service.PatientService;
import com.example.dtos.patient.PatientRequest;
import com.example.dtos.patient.PatientResponse;
import com.example.entity.Patient;
import com.example.exceptions.PatientNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    private final PatientService patientService;

    PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> findPatients(){
        return ResponseEntity.ok(patientService.getPatients());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findPatientsById(@PathVariable Long id) throws PatientNotFound {
        return ResponseEntity.ok(patientService.findById(id));
    }
    @PostMapping
    public ResponseEntity<PatientResponse> registerNewPatient(@Validated @RequestBody PatientRequest patient) {
        return new ResponseEntity<>(patientService.addNewPatient(patient), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatientsById(@PathVariable Long id, @RequestBody Patient patient) throws PatientNotFound {
        return new ResponseEntity<>(patientService.updatepatient(id, patient), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientsById(@PathVariable Long id) throws PatientNotFound {
        patientService.deletePatientById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<PatientResponse>> searchPatients(@PathVariable String searchString) throws PatientNotFound {
        return ResponseEntity.ok(patientService.searchPatient(searchString));
    }


}
