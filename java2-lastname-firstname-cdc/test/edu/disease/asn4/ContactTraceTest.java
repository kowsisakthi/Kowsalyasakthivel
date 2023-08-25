package edu.disease.asn4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.disease.asn3.DiseaseControlManager;
import edu.disease.asn3.DiseaseControlManagerImpl;
import edu.disease.asn3.Exposure;
import edu.disease.asn3.Patient;
import edu.disease.asn4.ContactTrace;
import edu.disease.asn4.PatientZero;

public class ContactTraceTest {
	static private Patient[] mockPatients;
	static DiseaseControlManager m;
	PatientZero P;

	@BeforeEach
	public void setUp() {
		// Create mock patients with exposures
		mockPatients = new Patient[1];
		Patient patient = new Patient(1, 1);
		Exposure exposure = new Exposure();
		exposure.setExposureType("D");
		exposure.setDateTime(LocalDateTime.of(2023, 8, 15, 12, 0)); // Replace with appropriate date and time
		patient.addExposure(exposure);
		mockPatients[0] = patient;
		m = new DiseaseControlManagerImpl(1, 1);
		m.addPatient("kamal", "raj", 1, 1);

	}

	
	@Test
	public void testFindPatientZero() {
		// Create a ContactTrace instance using the mock patient array
		ContactTrace contactTrace = new ContactTrace(m);

		// Create a test patient with exposures
		Patient testPatient = new Patient(1, 1);
		Exposure testExposure = new Exposure();
		testExposure.setExposureType("D");
		testExposure.setDateTime(LocalDateTime.of(2023, 8, 14, 12, 0)); // Replace with appropriate date and time
		testPatient.addExposure(testExposure);

		// Test finding patient zero
		PatientZero patientZero = contactTrace.findPatientZero(testPatient);

		assertNotNull(patientZero);
		assertEquals(testExposure.getDateTime(), patientZero.getExposureDateTime());
		assertTrue(patientZero.isExposed());
	}
}