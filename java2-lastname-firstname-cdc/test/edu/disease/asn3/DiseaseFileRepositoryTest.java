package edu.disease.asn3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.disease.asn3.Disease;

class DiseaseFileRepositoryTest {

	@Test
	void testSave() {
		Disease d1 = new InfectiousDisease();
		Disease d2 = new InfectiousDisease();
		Disease d3 = new InfectiousDisease();
		Disease d4 = new InfectiousDisease();
		Patient p1 = new Patient(2, 2);
		Patient p2 = new Patient(2, 2);
		Patient p3 = new Patient(2, 2);
		Patient p4 = new Patient(2, 2);
		Disease[] arr = { d1, d2, d3, d4 };
		Patient[] arr1 = { p1, p2, p3, p4 };
		DiseaseFileRepository re = new DiseaseFileRepository();
		re.setDiseasefile("dis.dat");
		re.setPatientfile("pat.dat");
		try {
			re.save(arr, arr1);
			re.setDiseasefile(null);
			assertThrows(IllegalArgumentException.class, () -> {re.save(arr, arr1);});
			re.setPatientfile(null);
			assertThrows(IllegalArgumentException.class, () -> {re.save(arr, arr1);});
			re.setPatientfile("pat.dat");
			assertThrows(IllegalArgumentException.class, () -> {re.save(arr, arr1);});
		} catch (Exception e) {
		}
	}

	
	
	@Test
	void testInit() {
		Disease d1 = new InfectiousDisease();
		Disease d2 = new InfectiousDisease();
		Disease d3 = new InfectiousDisease();
		Disease d4 = new InfectiousDisease();
		Patient p1 = new Patient(2, 2);
		Patient p2 = new Patient(2, 2);
		Patient p3 = new Patient(2, 2);
		Patient p4 = new Patient(2, 2);
		Disease[] arr = { d1, d2, d3, d4 };
		Patient[] arr1 = { p1, p2, p3, p4 };
		DiseaseFileRepository re = new DiseaseFileRepository();
		re.setDiseasefile("dise1.dat");
		re.setPatientfile("pat1.dat");
		try {
			re.save(arr, arr1);
			
		}catch(Exception e) {
			
		}
		try {
			DiseaseAndPatient de= re.init("C:\\Users\\HP\\Downloads\\VSKowsalya-main\\VSKowsalya-main\\java2-lastname-firstname-cdc\\");
			
			IllegalArgumentException i=	assertThrows(IllegalArgumentException.class, () -> {re.init(null);});
			assertEquals("The file paths are empty", i.getMessage());
			
		}catch(Exception e) {
		
			
			
		}
		
	}

}
