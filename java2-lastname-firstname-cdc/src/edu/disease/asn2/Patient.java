package edu.disease.asn2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

import edu.disease.asn1.Exposure;

public class Patient implements Comparable<Patient>{

	protected UUID patientId;
	private String firstName;
	private String lastName;
	private Exposure[] exposures;
	private UUID[] diseaselds;
	int maxP, maxD;

	public Patient(int maxDiseases, int maxExposures) {

		if (maxDiseases >= 0 || maxExposures >= 0) {
			this.diseaselds = new UUID[maxDiseases];
			this.exposures = new Exposure[maxExposures];
		} else {
			throw new IllegalArgumentException("Value should not be 0 or nagtivevalues");
		}

	}

	int index = 0;

	public void addDiseaseId(UUID diseaseId) {
		if (index >= maxD) {
			throw new IndexOutOfBoundsException("Memeory full");
		} else {
			diseaselds[index++] = diseaseId;
		}

	}

	public void addExposusre(Exposure exposure) {
		if (index >= maxP) {
			throw new IndexOutOfBoundsException("Memeory full");
		} else {
			exposures[index++] = exposure;
		}

	}

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public UUID[] getDiseaselds() {
		return diseaselds;
	}

	public Exposure[] getExposures() {
		return exposures;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", LastName=" + lastName
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaselds=" + Arrays.toString(diseaselds)
				+ ", maxP=" + maxP + ", maxD=" + maxD + ", index=" + index + "]";
	}

	@Override
	public int compareTo(Patient o) {
		if(this.lastName.compareTo(o.lastName)==0)
		{
			return this.firstName.toLowerCase().compareTo(o.firstName.toLowerCase());
		}
		return this.lastName.toLowerCase().compareTo(o.lastName);
	}

	

}
