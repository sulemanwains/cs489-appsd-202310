package edu.miu.lab9springsecurity.controller;

import edu.miu.lab9springsecurity.dto.PatientResponse;
import edu.miu.lab9springsecurity.exception.PatientNotFoundException;
import edu.miu.lab9springsecurity.models.Patient;
import edu.miu.lab9springsecurity.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "")
    public String patientHomePage(){
        return "Patient Home Page";
    }

    @GetMapping(value = "/list")
    public List<PatientResponse> getAllPatient(){
        return patientService.getAllPatients();
    }

    @GetMapping(value = "/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Patient> addNewPatient(@RequestBody Patient newPatient){
        return new ResponseEntity<>(patientService.addNewPatient(newPatient), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer patientId, @RequestBody Patient editedPatient){
        return new ResponseEntity<>(patientService.updatePatientById(patientId, editedPatient), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{patientId}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Integer patientId){
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatient(@PathVariable String searchString){
        return ResponseEntity.ok(patientService.searchPatient(searchString));
    }
}
