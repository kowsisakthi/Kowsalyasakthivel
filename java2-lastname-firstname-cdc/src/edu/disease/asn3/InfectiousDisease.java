package edu.disease.asn3;

import java.util.UUID;

/**
 * A subclass of Disease representing infectious diseases. This class provides
 * specific examples of infectious diseases.
 */
public class InfectiousDisease extends Disease {
	

	/**
	 * Retrieves an  of example infectious disease names.
	 *
	 * @return An array of example infectious disease names.
	 */
	@Override
	public String[] getExamples() {
		String[] infecD = { "COVID", "HIV", "Chickenpox", "Cold" };
		return infecD;
	}

}