package edu.disease.asn3;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * This abstract class represents an Disease object and implements the serializable.
 */
public abstract class Disease implements Serializable{


	private static final long serialVersionUID = 1L;
	/**
	 * The UUID representing a disease identifier.
	 */
	UUID diseaseId;
	/**
	 * The name associated with the disease.
	 */
	String name;

	/**
	 * Gets the UUID representing a disease identifier.
	 *
	 * @return The UUID representing a disease identifier.
	 */
	public UUID getDiseaseId() {
        return diseaseId;
    }

	
	
	/**
	 * Sets the UUID representing a disease identifier.
	 *
	 * @param diseaseld The UUID representing a disease identifier to set.
	 */
	public void setDiseaseld(UUID diseaseld) {
		this.diseaseId = diseaseld;
	}

	/**
	 * Gets the name associated with the disease.
	 *
	 * @return The name associated with the disease.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name associated with the disease.
	 *
	 * @param name The name associated with the disease to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Generates a hash code value for this Disease object. The hash code is
	 * calculated based on the value of the diseaseld field.
	 *
	 * @return A hash code value for this Disease object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31; // A prime constant used in the hash code calculation.
		int result = 1; // The running total of the hash code calculation, starting with 1.

		// Calculate the hash code of the diseaseld field, if it's not null.
		result = prime * result + ((diseaseId == null) ? 0 : diseaseId.hashCode());

		return result; // Return the final calculated hash code.
	}

	/**
	 * Compares this Disease object to another object for equality. Two Disease
	 * objects are considered equal if their diseaseld and name fields are equal.
	 *
	 * @param obj The object to compare with this Disease object.
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

		Disease other = (Disease) obj;

		// Compare the diseaseld and name fields for equality, accounting for null
		// values.
		return Objects.equals(diseaseId, other.diseaseId) && Objects.equals(name, other.name);
	}

	/**
	 * Returns a string representation of this Disease object. The returned string
	 * includes information about the disease's ID and name.
	 *
	 * @return A string representation of this Disease object.
	 */
	@Override
	public String toString() {
		return "Disease [diseaseld=" + diseaseId + ", name=" + name + "]";
	}

	/**
	 * Retrieves an array of example strings. This method is meant to be implemented
	 * by subclasses to provide specific examples.
	 *
	 * @return An array of example strings.
	 */
	abstract public String[] getExamples();

	public Disease(UUID diseaseId, String name) {
	    this.diseaseId = diseaseId;
	    this.name = name;
	}

	public Disease() {
		// TODO Auto-generated constructor stub
	}
	
}

/**
 * A subclass of Disease representing infectious diseases. This class provides
 * specific examples of infectious diseases.
 */
class InfectiousDisease extends Disease {
	public InfectiousDisease(UUID diseaseId, String name) {
		// TODO Auto-generated constructor stub
	}	

	/**
	 * Retrieves an array of example infectious disease names.
	 *
	 * @return An array of example infectious disease names.
	 */
	@Override
	public String[] getExamples() {
		String[] infecD = { "COVID", "HIV", "Chickenpox", "Cold" };
		return infecD;
	}

}

/**
 * A subclass of Disease representing non-infectious diseases. This class
 * provides specific examples of non-infectious diseases.
 */
class NonInfectiousDisease extends Disease {
	
	public NonInfectiousDisease(UUID diseaseId, String name) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retrieves an array of example non-infectious disease names.
	 *
	 * @return An array of example non-infectious disease names.
	 */
	@Override
	public String[] getExamples() {
		String[] nonInfec = { "Stroke", "Heartattack", "Cancers", "Cardiovascular " };
		return nonInfec;
	}
	
}
