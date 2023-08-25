package edu.disease.asn1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class ExposureTest {
	@Test
	void testcon() {
		Exposure e=new Exposure(UUID.randomUUID());
		assertTrue(e instanceof Exposure);
	}
	@Test
	void testHashCode() {
		UUID patient= UUID.randomUUID();
		Exposure e=new Exposure(patient);
		int result =31*patient.hashCode();
		
		assertTrue(result==e.hashCode());
	}
	@Test
	void testHashCode1() {
		UUID patient= null;
		Exposure e=new Exposure(patient);
		//int result =31*patient.hashCode();
		
		assertTrue(0==e.hashCode());
	}
	@Test
	void testHashCode2() {
		UUID patient= null;
		Exposure e=new Exposure(patient);
		LocalDateTime d= LocalDateTime.now();
		e.setDateTime(d);
		int result =31*d.hashCode();
		
		assertTrue(result==e.hashCode());
	}




	@Test
	void testGetPatientld() {
		UUID patient= UUID.randomUUID();
		Exposure e=new Exposure(patient);
		assertEquals(patient, e.getPatientld());
	}

	@Test
	void testGetDateTime() {
		LocalDateTime d= LocalDateTime.now();
		UUID patient= UUID.randomUUID();
		Exposure e=new Exposure(patient);
		e.setDateTime(d);
		assertEquals(d, e.getDateTime());
		
	}

	

	@Test
	void testSetExposureType() {
		UUID patient= UUID.randomUUID();
		Exposure e=new Exposure(patient);
		e.setExposureType("D");
		assertEquals("D", e.getExposureType());
	}
	@Test
	void testSetExposureType1() {
		UUID patient= UUID.randomUUID();
		Exposure e=new Exposure(patient);
		e.setExposureType("I");
		assertEquals("I", e.getExposureType());
	}
	@Test
	void testSetExposureType3() {
		UUID patient= UUID.randomUUID();
		Exposure e=new Exposure(patient);
		 assertThrows(IllegalArgumentException.class, ()->e.setExposureType("kowsi"));
		
	}
	

	@Test
	void testEqualsObject() {
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(patient);
		Exposure e2=new Exposure(patient);
		assertTrue(e1.equals(e2));
		
	}
	@Test
	void testEqualsObject1() {
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(patient);
		Exposure e2=e1;
		assertTrue(e1.equals(e2));
		
	}

	@Test
	void testEqualsObject3() {
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(patient);
		Exposure e2=null;
		assertFalse(e1.equals(e2));
		
	}
	@Test
	void testEqualsObject4() {
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(patient);
		assertFalse(e1.equals("kowsi"));
		
	}
	@Test
	void testEqualsObject5() {
		LocalDateTime d= LocalDateTime.now();
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(patient);
		e1.setDateTime(d);
		Exposure e2=new Exposure(patient);
		assertFalse(e1.equals(e2));
		
	}
	@Test
	void testEqualsObject6() {
		LocalDateTime d= LocalDateTime.now();
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(patient);
		e1.setDateTime(d);
		Exposure e2=new Exposure(patient);
		assertFalse(e2.equals(e1));
		
	}
	@Test
	void testEqualsObject7() {
		LocalDateTime d= LocalDateTime.now();
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(patient);
		e1.setDateTime(d);
		
		Exposure e2=new Exposure(patient);
		e2.setDateTime(d);
		assertTrue(e2.equals(e1));
		
	}
	@Test
	void testEqualsObject8() {
		LocalDateTime d= LocalDateTime.now();
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(null);
		
		Exposure e2=new Exposure(patient);
		assertFalse(e1.equals(e2));
		
	}
	@Test
	void testEqualsObject9() {
		LocalDateTime d= LocalDateTime.now();
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(null);
		
		Exposure e2=new Exposure(null);
		assertTrue(e1.equals(e2));
		
	}
	@Test
	void testEqualsObject10() throws InterruptedException {
		LocalDateTime d= LocalDateTime.now();
		UUID patient= UUID.randomUUID();
		Exposure e1=new Exposure(patient);
		Thread.sleep(1000);
		UUID patient2= UUID.randomUUID();
		Exposure e2=new Exposure(patient2);
		assertFalse(e1.equals(e2));
		
	}
	@Test
	void testToString() {
		LocalDateTime dateTime= LocalDateTime.now();
		UUID patientld= UUID.randomUUID();
		String exposureType ="D";
		Exposure e1=new Exposure(patientld);
		e1.setExposureType(exposureType);
		assertTrue(("patientId=" + patientld + " "+ "dateTime=" 
		+ dateTime + " " + "exposureType=" + exposureType).equals(e1.toString()));
		
		
	}

}
