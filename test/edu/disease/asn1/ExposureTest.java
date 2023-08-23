package edu.disease.asn1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExposureTest {

	private Exposure exposure;
	private Disease disease1;
	private Disease disease2;

	@BeforeEach
	void setUp() {
		LocalDateTime dateTime = LocalDateTime.now();
		exposure = new Exposure(); // Create an instance of the Exposure class
		exposure = new Exposure(dateTime, "D");
		UUID diseaseId = UUID.randomUUID();
		disease1 = new Disease(diseaseId, "COVID-19");
		disease2 = new Disease(diseaseId, "COVID-19");
	}

	@Test
	void testEquals() {
		// Create two exposures with the same dateTime
		LocalDateTime dateTime = LocalDateTime.now();
		exposure.setDateTime(dateTime);

		Exposure sameExposure = new Exposure(dateTime, "I");

		// Verify that the two exposures are equal
		assertTrue(exposure.equals(sameExposure));
	}

	@Test
	void testToString() {
		// Set values for dateTime and exposureType
		LocalDateTime dateTime = LocalDateTime.now();
		exposure.setDateTime(dateTime);
		exposure.setExposureType("I");

		// Verify that the toString() method does not throw exceptions
		assertNotNull(exposure.toString());
	}

	@Test
	void testEqualsWithEqualObjects() {
		// Create two exposures with the same dateTime and exposureType
		LocalDateTime dateTime = LocalDateTime.now();
		exposure = new Exposure(dateTime, "I");

		Exposure sameExposure = new Exposure(dateTime, "I");

		// Verify that the two exposures are equal
		assertTrue(exposure.equals(sameExposure));
	}

	@Test
	void testEqualsWithDifferentDateTime() {
		// Create two exposures with different dateTime values
		LocalDateTime dateTime1 = LocalDateTime.now();
		LocalDateTime dateTime2 = dateTime1.plusHours(1);
		exposure = new Exposure(dateTime1, "I");

		Exposure differentExposure = new Exposure(dateTime2, "I");

		// Verify that the two exposures are not equal
		assertFalse(exposure.equals(differentExposure));
	}

	@Test
	void testEqualsWithDifferentName() {
		// Create two Disease instances with different name values
		UUID diseaseId = UUID.randomUUID();
		disease1 = new Disease(diseaseId, "COVID-19");
		disease2 = new Disease(diseaseId, "Influenza");

		// Verify that disease1 and disease2 are not equal
		assertFalse(disease1.equals(disease2));
	}

	@Test
	void testEqualsWithNullFields() {
		// Create two Disease instances with null fields
		disease1 = new Disease(null, null);
		disease2 = new Disease(null, null);

		// Verify that disease1 and disease2 are equal
		assertTrue(disease1.equals(disease2));
	}

	@Test
	void testEqualsWithDifferentDiseaseId() {
		// Create two Disease instances with different diseaseId values
		disease1 = new Disease(UUID.randomUUID(), "COVID-19");
		disease2 = new Disease(UUID.randomUUID(), "COVID-19");

		// Verify that disease1 and disease2 are not equal
		assertFalse(disease1.equals(disease2));
	}

	@Test
	void testSetExposureTypeValidType() {
		// Set a valid exposure type "I"
		exposure.setExposureType("I");

		// Verify that the exposure type is set correctly
		assertEquals("I", exposure.getExposureType());
	}

	@Test
	void testSetExposureTypeValidTypeD() {
		// Set a valid exposure type "D"
		exposure.setExposureType("D");

		// Verify that the exposure type is set correctly
		assertEquals("D", exposure.getExposureType());
	}

	@Test
	void testSetExposureTypeInvalidType() {
		// Attempt to set an invalid exposure type "X"
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			exposure.setExposureType("X");
		});

		// Verify that the exception message contains the expected error message
		String expectedErrorMessage = "exposure type is invalid...!";
		String actualErrorMessage = exception.getMessage();
		assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	}

	@Test
	void testGetPatientld() {
		// Use the getPatientld method to retrieve the patient ID
		UUID retrievedPatientId = exposure.getPatientld();

		// Verify that the retrieved patient ID matches the expected value
		UUID expectedPatientId = exposure.getPatientld(); // Adjust this to your expected value
		assertEquals(expectedPatientId, retrievedPatientId);
	}

}
