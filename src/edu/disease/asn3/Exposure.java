package edu.disease.asn3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * This class represents an Exposure object and implements Serializable.
 */
public class Exposure implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/**
	 * The UUID of the patient associated with this exposure.
	 */
	private UUID patientld;
	/**
	 * The date and time of the exposure event.
	 */
	private LocalDateTime dateTime;
	/**
	 * The type of exposure event (I for Indirect , D for Direct ).
	 */
	private String exposureType;

	/**
	 * Constructs an Exposure object with the given date and exposure type.
	 *
	 * @param dateTime     The date and time of the exposure event.
	 * @param exposureType The type of exposure (I for Indirect, D for Direct).
	 */
	public Exposure(UUID patientld) {
		this.patientld=patientld;
	}
	

	/**
	 * Retrieves the UUID of the patient associated with this exposure.
	 *
	 * @return The UUID of the patient.
	 */
	public UUID getPatientld() {
		return patientld;
	}

	/**
	 * Retrieves the date and time of the exposure event.
	 *
	 * @return The date and time of the exposure event.
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	
	/**
	 * Sets the date and time of the exposure event.
	 *
	 * @param dateTime The date and time of the exposure event.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Retrieves the type of exposure event.
	 *
	 * @return The type of exposure event (I for Indirect, D for Direct).
	 */
	public String getExposureType() {
		return exposureType;
	}

	/**
	 * Sets the type of exposure event.
	 *
	 * @param exposureType The type of exposure event (I for Indirect, D for
	 *                     Direct).
	 * @throws IllegalArgumentException If the provided exposure type is invalid.
	 */
	public void setExposureType(String exposureType) {
		if (exposureType.equals("I") || exposureType.equals("D")) {
			this.exposureType = exposureType;
		} else {
			throw new IllegalArgumentException("exposure type is invalid...!");
		}

	}

	/**
	 * Generates a hash code value for this Exposure object. The hash code is
	 * calculated based on the values of the dateTime and patientld fields.
	 *
	 * @return A hash code value for this Exposure object.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dateTime, patientld);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposure other = (Exposure) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(patientld, other.patientld);
	}

	
	public Exposure() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a string representation of this Exposure object. The string includes
	 * information about the patientId, dateTime, and exposureType fields.
	 *
	 * @return A string representation of this Exposure object.
	 */
	@Override
	public String toString() {
		return "patientId=" + patientld + " " + "dateTime=" + dateTime + " " + "exposureType=" + exposureType;
	}

}

