package edu.disease.asn6;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import edu.disease.asn3.Exposure;

/**
 * Represents a patient with related properties and methods. This class is
 * implemented the Comparable,Serializable.
 */
public class Patient implements Comparable<Patient>, Serializable {

	private static final long serialVersionUID = 1L;
	private UUID patientId;
	private String firstName;
	private String lastName;
	private List<Exposure> exposures;
	private List<UUID> diseaseIds;
	private int exposureCount;
	private int diseaseCount;

	/**
	 * Constructs a new patient with the given maximum diseases and exposures.
	 *
	 * @param maxDiseases  The maximum number of diseases this patient can have.
	 * @param maxExposures The maximum number of exposures this patient can have.
	 * @throws IllegalArgumentException if maxDiseases or maxExposures is less than
	 *                                  or equal to 0.
	 */
	public Patient() {
	}

	/**
	 * Adds a disease ID to the patient's list of disease IDs.
	 *
	 * @param diseaseId The UUID of the disease to add.
	 * @throws IndexOutOfBoundsException if the diseaseIds array is full.
	 */
	public void addDiseaseId(UUID diseaseId) {
		diseaseIds.add(diseaseId);
	}

	/**
	 * Adds an exposure to the patient's list of exposures.
	 *
	 * @param exposure The exposure to add.
	 * @throws IndexOutOfBoundsException if the exposures array is full.
	 */
	public void addExposure(Exposure exposure) {

		exposures.add(exposure);
	}

	// Getter and setter methods for firstName, lastName, and other properties

	public UUID getPatientId() {
		return patientId;
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
		this.lastName = lastName;
	}

	// Add getters and setters for other properties

	public int getExposureCount() {
		return exposureCount;
	}

	public void setExposureCount(int exposureCount) {
		this.exposureCount = exposureCount;
	}

	public int getDiseaseCount() {
		return diseaseCount;
	}

	public void setDiseaseCount(int diseaseCount) {
		this.diseaseCount = diseaseCount;
	}

	public List<Exposure> getExposures() {
		return exposures;
	}

	public void setExposures(List<Exposure> exposures) {
		this.exposures = exposures;
	}

	public List<UUID> getDiseaseIds() {
		return diseaseIds;
	}

	public void setDiseaseIds(List<UUID> diseaseIds) {
		this.diseaseIds = diseaseIds;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	/**
	 * Generates a hash code value for this Patient object. The hash code is
	 * calculated based on the value of the patientId field.
	 *
	 * @return A hash code value for this Patient object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}

	/**
	 * Compares this Patient object to another object for equality. Two Patient
	 * objects are considered equal if their patientId fields are equal.
	 *
	 * @param obj The object to compare with this Patient object.
	 * @return {@code true} if the objects are equal, {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Patient other = (Patient) obj;

		// Compare the patientId fields for equality, accounting for null values.
		return Objects.equals(patientId, other.patientId);
	}

	/**
	 * Returns a string representation of this Patient object. The string includes
	 * information about the patient's ID, first name, last name, exposure events,
	 * and associated disease IDs.
	 *
	 * @return A string representation of this Patient object.
	 */

	public int compareTo(Patient other) {
		// Null checks for last names
		if (this.lastName == null && other.lastName == null) {
			// Both last names are null, consider them equal
			return this.firstName.compareToIgnoreCase(other.firstName);
		} else if (this.lastName == null) {
			// Only this patient's last name is null, consider the other patient greater
			return 1;
		} else if (other.lastName == null) {
			// Only the other patient's last name is null, consider this patient greater
			return -1;
		}

		// Compare by last name (case-insensitive), then by first name
		// (case-insensitive)
		int lastNameComparison = this.lastName.compareToIgnoreCase(other.lastName);
		if (lastNameComparison == 0) {
			return this.firstName.compareToIgnoreCase(other.firstName);
		}
		return lastNameComparison;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + exposures + ", diseaseIds=" + diseaseIds + ", exposureCount=" + exposureCount
				+ ", diseaseCount=" + diseaseCount + "]";
	}

}
