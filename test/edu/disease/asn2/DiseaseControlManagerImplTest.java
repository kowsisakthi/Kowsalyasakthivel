package edu.disease.asn2;import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.disease.asn1.Exposure;


public class DiseaseControlManagerImplTest {

    private DiseaseControlManager diseaseControlManager;
    @BeforeEach
    void setUp() {
        // Initialize DiseaseControlManager with maximum capacities of 5 diseases and 5 patients
        diseaseControlManager = new DiseaseControlManagerImpl(5, 5);;
		

    }


    @Test
    void testGetPatient() {
        // Add a new patient
        Patient patient = diseaseControlManager.addPatient("Raju", "Ram", 2, 4);
        assertNotNull(patient);

        // Get the patient by their ID
        Patient retrievedPatient = diseaseControlManager.getPatient(patient.getPatientId());
        assertNotNull(retrievedPatient);
        assertEquals(patient.getPatientId(), retrievedPatient.getPatientId());

        // Try to get a non-existent patient
        UUID nonExistentPatientId = UUID.randomUUID();
        Patient nonExistentPatient = diseaseControlManager.getPatient(nonExistentPatientId);
        assertNull(nonExistentPatient);
    }
    
    @Test
    public void testGetDiseaseWhenDiseaseDoesNotExist() {
        // Attempt to retrieve a disease with a random UUID
        UUID randomUuid = UUID.randomUUID();
        Disease retrievedDisease = diseaseControlManager.getDisease(randomUuid);

        // Assert that the retrieved disease is null since it doesn't exist
        assertNull(retrievedDisease);
    }

    @Test
    public void testAddExposureToPatientWithInvalidPatientId() {
    	LocalDateTime dateTime = LocalDateTime.now();
        // Attempt to add an exposure to a patient with an invalid/random UUID
        UUID randomUuid = UUID.randomUUID();
        Exposure exposure = new Exposure(dateTime, "COVID-19");

        // Verify that adding exposure to a non-existent patient throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
        	diseaseControlManager.addExposureToPatient(randomUuid, exposure);
        });
    }  
    
    @Test
    public void testAddExposureToPatient() {
    	LocalDateTime dateTime = LocalDateTime.now();
        // Add a patient to the manager
        Patient patient = diseaseControlManager.addPatient("Kowsi", "sakthi", 5, 10);

        // Create an Exposure object
        Exposure exposure = new Exposure(dateTime, "COVID-19");

        // Add the exposure to the patient
        diseaseControlManager.addExposureToPatient(patient.getPatientId(), exposure);

        // Retrieve the patient again
        Patient retrievedPatient = diseaseControlManager.getPatient(patient.getPatientId());

        // Assert that the retrieved patient is not null
        assertNotNull(retrievedPatient);

    }
    
    @Test
    public void testAddDiseaseToPatientWithInvalidPatientId() {
        // Add a disease to the manager
        Disease disease = diseaseControlManager.addDisease("COVID-19", true);

        // Attempt to add the disease to a patient with an invalid/random UUID
        UUID randomUuid = UUID.randomUUID();

        // Verify that adding the disease to a non-existent patient throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
        	diseaseControlManager.addDiseaseToPatient(randomUuid, disease.getDiseaseId());
        });
    }
    
    @Test
    public void testGetDiseaseWithInvalidId() {
        // Attempt to retrieve a disease using an invalid/random UUID
        UUID randomUuid = UUID.randomUUID();

        // Verify that retrieving a disease with an invalid UUID returns null
        assertNull(diseaseControlManager.getDisease(randomUuid));
    }
    
        
    
}
