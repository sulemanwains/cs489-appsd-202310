package com.example.Service.Impl;

import com.example.Service.PatientService;
import com.example.dtos.address.AddressResponse;
import com.example.dtos.patient.PatientResponse;
import com.example.dtos.patient.PatientResponse2;
import com.example.exceptions.PatientNotFound;
import jakarta.inject.Inject;
import net.bytebuddy.asm.Advice.Local;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void testFindPatientByIdValid() throws PatientNotFound {
        PatientResponse testPatient = new PatientResponse(1l, "Alice", "Brown", "alice.brown@example.com", "4th ST", new AddressResponse("Townsville", "456 Elm St", "54321"));
        PatientResponse foundPatient = patientService.findById(1L);
        assertEquals(testPatient, foundPatient);
    }

    @Test
    public void testFindPatientByIdInvalid() throws PatientNotFound {
        Long invalidPatientId = 99L;

        assertThrows(PatientNotFound.class, () -> {
            patientService.findById(invalidPatientId);
        });
    }
}