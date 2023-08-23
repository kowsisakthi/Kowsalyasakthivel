package edu.disease.asn1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    private Patient patient;
    private UUID diseaseId1;
    private UUID diseaseId2;
    private Exposure exposure1;
    private Exposure exposure2;

    @BeforeEach
    void setUp() {
    	LocalDateTime dateTime = LocalDateTime.now();
        patient = new Patient(2, 2);
        diseaseId1 = UUID.randomUUID();
        diseaseId2 = UUID.randomUUID();
        exposure1 = new Exposure(dateTime, "D");
        exposure2 = new Exposure(dateTime,"I");
    }

    @Test
    void testAddDiseaseId() {
        patient.addDiseaseId(diseaseId1);
        assertEquals(1, patient.getDiseaseCount());
        assertArrayEquals(new UUID[]{diseaseId1, null}, patient.getDiseaseIds());
    }

    @Test
    void testAddExposure() {
        patient.addExposure(exposure1);
        assertEquals(1, patient.getExposureCount());
        assertArrayEquals(new Exposure[]{exposure1, null}, patient.getExposures());
    }
    
    @Test
    void testToString() {
        // Ensure that the toString() method does not throw exceptions
        assertNotNull(patient.toString());
    }
    
    @Test
    void testSetValidExposureType() {
        // Set a valid exposure type ("I")
    	exposure2.setExposureType("I");

        // Verify that the exposure type has been set correctly
        assertEquals("I", exposure2.getExposureType());
    }
    
    @Test
    void testEquals() {
        Patient samePatient = new Patient(3, 4);
        samePatient.setPatientId(patient.getPatientId());

        assertTrue(patient.equals(samePatient));
    }
    
    @Test
    void testSetLastName() {
        String lastName = "Sakthi";
        patient.setLastName(lastName);

        assertEquals(lastName, patient.getLastName());
    }

    @Test
    void testHashCode() {
        int hashCode = patient.hashCode();

        // Ensure that the hashCode does not throw exceptions
        assertNotNull(hashCode);
    }
       
    @Test
    void testGetPatientId() {
        UUID generatedId = patient.getPatientId();
        assertNotNull(generatedId);
    }

    @Test
    void testSetFirstName() {
        String firstName = "Kowsi";
        patient.setFirstName(firstName);

        assertEquals(firstName, patient.getFirstName());
    }
    
    @Test
    void testAddDiseaseld() {
        patient.addDiseaseId(diseaseId2);

        UUID[] diseaseIds = patient.getDiseaseIds();
        assertNotNull(diseaseIds);
    }
    
    @Test
    public void testConstructorWithValidValues() {
        // Test constructor with valid values for maxDiseases and maxExposures
        int maxDiseases = 5;
        int maxExposures = 10;

        Patient patient = new Patient(maxDiseases, maxExposures);

        // Assert that the Patient object is not null
        assertNotNull(patient);

        // Assert that the patientId is not null
        assertNotNull(patient.getPatientId());

        // Assert that exposures and diseaseIds arrays are correctly initialized
        assertEquals(maxDiseases, patient.getDiseaseIds().length);
        assertEquals(maxExposures, patient.getExposures().length);
        assertEquals(0, patient.getExposureCount());
        assertEquals(0, patient.getDiseaseCount());
    }
}
