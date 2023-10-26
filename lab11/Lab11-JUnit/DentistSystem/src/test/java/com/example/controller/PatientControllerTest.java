package com.example.controller;

import com.example.Service.PatientService;
import com.example.dtos.address.AddressResponse;
import com.example.dtos.patient.PatientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.session.DefaultMockitoSessionBuilder;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PatientControllerTest {
    @InjectMocks
    private PatientController patientController;
    @Mock
    private PatientService patientService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testFindPatients() {

        List<PatientResponse> expectedPatients = new ArrayList<>();
        expectedPatients.add(new PatientResponse(1l, "Alice", "Brown", "alice.brown@example.com", "4th ST", new AddressResponse("Townsville", "456 Elm St", "54321")));
        expectedPatients.add(new PatientResponse(29, "Suleman", "Asghar", "suleman.venus2@gmail.com", "1000 N 4th ST", new AddressResponse("Fairfiled", "4 St", "52557")));

        when(patientService.getPatients()).thenReturn(expectedPatients);

        ResponseEntity<List<PatientResponse>> responseEntity = patientController.findPatients();

        assertEquals(expectedPatients, responseEntity.getBody());
    }
}