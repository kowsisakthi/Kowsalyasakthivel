package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;

/**
 * This class represents an Disease object. It stores basic information such as
 * diseaseld,name.
 */
public class Disease {
	/**
	 * The UUID representing a disease identifier.
	 */
	UUID diseaseld;
	/**
	 * The name associated with the disease.
	 */
	String name;

	public Disease() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the UUID representing a disease identifier.
	 *
	 * @return The UUID representing a disease identifier.
	 */
	public UUID getDiseaseld() {
		return diseaseld;
	}

	/**
	 * Sets the UUID representing a disease identifier.
	 *
	 * @param diseaseld The UUID representing a disease identifier to set.
	 */
	public void setDiseaseld(UUID diseaseld) {
		this.diseaseld = diseaseld;
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
		result = prime * result + ((diseaseld == null) ? 0 : diseaseld.hashCode());

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
		return Objects.equals(diseaseld, other.diseaseld) && Objects.equals(name, other.name);
	}

	/**
	 * Returns a string representation of this Disease object. The returned string
	 * includes information about the disease's ID and name.
	 *
	 * @return A string representation of this Disease object.
	 */
	@Override
	public String toString() {
		return "Disease [diseaseld=" + diseaseld + ", name=" + name + "]";
	}

	

}
