package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public interface DiseaseControlManager {
	public Disease addDisease(String name,boolean infectious );
	public Disease getDisease(UUID diseaseld );
	public Patient	addPatient(String fistName,String lastName,int maxDiseases,int maxExposures );
	public Patient getPatient(UUID patientld );
	public void addDiseaseToPatient(UUID patientld,UUID diseaseld);
	public void addExposureToPatient(UUID patientld,Exposure exposure );
}
