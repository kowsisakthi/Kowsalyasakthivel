package edu.disease.asn6;

import java.util.List;
import java.util.UUID;

import edu.disease.asn3.Disease;
import edu.disease.asn3.Exposure;

public interface DiseaseControlManager {

	/**
	 * Adds a new disease to the application.
	 *
	 * @param name       A name for the disease.
	 * @param infectious True if the disease is infectious, false otherwise.
	 * @return The newly created Disease object.
	 * @throws IllegalStateException if the maximum capacity of diseases has been
	 *                               reached.
	 */
	public Disease addDisease(String name, boolean infectious);

	/**
	 * Returns the disease with the specified disease ID.
	 *
	 * @param diseaseId The ID of the disease to retrieve.
	 * @return The Disease object with the specified ID, or null if not found.
	 */
	public Disease getDisease(UUID diseaseId);

	/**
	 * Adds a new patient to the application.
	 *
	 * @param firstName    The first name of the patient.
	 * @param lastName     The last name of the patient.
	 * @param maxDiseases  The maximum number of diseases this patient can have.
	 * @param maxExposures The maximum number of exposures this patient can have.
	 * @return The newly created Patient object.
	 * @throws IllegalStateException if the maximum capacity of patients has been
	 *                               reached.
	 */
	public Patient addPatient(String firstName, String lastName);

	/**
	 * Returns the patient with the specified patient ID.
	 *
	 * @param patientId The ID of the patient to retrieve.
	 * @return The Patient object with the specified ID, or null if not found.
	 */
	public Patient getPatient(UUID patientId);

	/**
	 * Adds a disease to a patient.
	 *
	 * @param patientId The ID of the patient.
	 * @param diseaseId The ID of the disease to add.
	 * @throws IllegalArgumentException if the patient or disease is not found.
	 */
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId);

	/**
	 * Adds an exposure to a patient.
	 *
	 * @param patientId The ID of the patient.
	 * @param exposure  The Exposure object to add.
	 * @throws IllegalArgumentException if the patient is not found.
	 */
	public void addExposureToPatient(UUID patientId, Exposure exposure);

	/**
	 * Gets the List of Disease objects stored in this container.
	 *
	 * @return The List of Disease objects, or null if no diseases are stored.
	 */
	public List<Disease> getDisease();

	/**
	 * Gets the List of Patient objects stored in this container.
	 *
	 * @return The List of Patient objects, or null if no patients are stored.
	 */

	public List<Patient> getPatient();
}
