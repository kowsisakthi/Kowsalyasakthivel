package edu.disease.asn3;

import java.util.UUID;

public class NonInfectiousDisease extends Disease {

	

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