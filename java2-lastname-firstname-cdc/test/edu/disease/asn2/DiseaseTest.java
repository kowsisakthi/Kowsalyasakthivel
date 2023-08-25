package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class DiseaseTest {

    private Disease disease;
    private InfectiousDisease infectiousDisease;
    private NonInfectiousDisease nonInfectiousDisease;

    @BeforeEach
    void setUp() {
        // Create sample diseases
        disease = new Disease() {
			
			@Override
			public String[] getExamples() {
				// TODO Auto-generated method stub
				return null;
			}
		};
        infectiousDisease = new InfectiousDisease(UUID.randomUUID(), "Infectious Disease");
        nonInfectiousDisease = new NonInfectiousDisease(UUID.randomUUID(), "Non-Infectious Disease");
    
    }


    @Test
    void testDiseaseSetters() {
        UUID newId = UUID.randomUUID();
        disease.setDiseaseld(newId);
        assertEquals(newId, disease.getDiseaseId());

        disease.setName("New Disease Name");
        assertEquals("New Disease Name", disease.getName());

        infectiousDisease.setDiseaseld(newId);
        assertEquals(newId, infectiousDisease.getDiseaseId());

        infectiousDisease.setName("New Infectious Disease Name");
        assertEquals("New Infectious Disease Name", infectiousDisease.getName());

        nonInfectiousDisease.setDiseaseld(newId);
        assertEquals(newId, nonInfectiousDisease.getDiseaseId());

        nonInfectiousDisease.setName("New Non-Infectious Disease Name");
        assertEquals("New Non-Infectious Disease Name", nonInfectiousDisease.getName());
    }

    @Test
    void testDiseaseEquals() {
        // Diseases with the same ID and name should be equal
        assertTrue(disease.equals(disease));

        // Diseases with different IDs or names should not be equal
        assertFalse(disease.equals(null));
        assertFalse(disease.equals(new Object()));

        // Subclasses should be equal to themselves and not equal to instances of the base class
        assertTrue(infectiousDisease.equals(infectiousDisease));
        assertFalse(infectiousDisease.equals(disease));

        assertTrue(nonInfectiousDisease.equals(nonInfectiousDisease));
        assertFalse(nonInfectiousDisease.equals(disease));
    }


    @Test
    void testInfectiousDiseaseGetExamples() {
        String[] examples = infectiousDisease.getExamples();
        assertNotNull(examples);
        assertEquals(4, examples.length);
    }

    @Test
    void testNonInfectiousDiseaseGetExamples() {
        String[] examples = nonInfectiousDisease.getExamples();
        assertNotNull(examples);
        assertEquals(4, examples.length);
    }
}

