package edu.disease.asn3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class DiseaseControlManagerImplTest {

	@Test
	void testDiseaseControlManagerImpl() {
		DiseaseControlManagerImpl t= new DiseaseControlManagerImpl(10, 20);
		t= new DiseaseControlManagerImpl(0, 0);
		t= new DiseaseControlManagerImpl(10, 0);
		t= new DiseaseControlManagerImpl(0, 20);
		t= new DiseaseControlManagerImpl(-2, -2);
		t= new DiseaseControlManagerImpl(-2, 20);
		t= new DiseaseControlManagerImpl(10, -20);
		
	}
	 

	@Test
	void testAddDisease() {
		DiseaseControlManagerImpl t= new DiseaseControlManagerImpl(1, 1);
		t.addDisease("kowsi", true);
		t.addDisease("kowsi", false);
		t= new DiseaseControlManagerImpl(1, 1);
		t.addDisease("kowsi", false);
		
		
	}

	@Test
	void testGetDiseaseUUID() {
		DiseaseControlManagerImpl t= new DiseaseControlManagerImpl(1, 1);
		t.getDisease();
	}

	@Test
	void testAddPatient() {
		DiseaseControlManagerImpl t= new DiseaseControlManagerImpl(1, 1);
		t.addPatient("Kowsi", "s", 1, 1);
		t.addPatient("sakthi", "R", 1, 2);
	}

	@Test
	void testGetPatientUUID() {
		DiseaseControlManagerImpl t= new DiseaseControlManagerImpl(1, 1);
		UUID pt=UUID.randomUUID();
		t.addPatient("Kowsi", "s", 1, 1).setPatientId(pt);
		//t.addPatient("sakthi", "R", 1, 2).setPatientId(UUID.randomUUID());
		t.getPatient(pt);
		t= new DiseaseControlManagerImpl(1, 1);
		//UUID pt=UUID.randomUUID();
		t.addPatient("Kowsi", "s", 1, 1).setPatientId(pt);
		//t.addPatient("sakthi", "R", 1, 2).setPatientId(UUID.randomUUID());
		t.getPatient(UUID.randomUUID());
	}

	@Test
	void testAddDiseaseToPatient() {
		fail("Not yet implemented");
	}

	@Test
	void testAddExposureToPatient() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDisease() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPatient() {
		fail("Not yet implemented");
	}

}
