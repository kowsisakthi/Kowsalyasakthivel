package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

/**
 * An implementation of the DiseaseControlManager interface that manages diseases and patients.
 */
public class DiseaseControlManagerImpl implements DiseaseControlManager {

	 /**
     * An array to store Disease objects.
     */
	private Disease[] diseases;


    /**
     * An array to store Patient objects.
     */
    private Patient[] patients;

    /**
     * The count of diseases currently stored in the diseases array.
     */
    private int diseaseCount;

    /**
     * The count of patients currently stored in the patients array.
     */
    private int patientCount;

    /**
     * Constructs a new DiseaseControlManagerImpl instance.
     *
     * @param maxDiseases The maximum number of diseases that can be stored.
     * @param maxPatients The maximum number of patients that can be stored.
     * @throws IllegalArgumentException if maxDiseases or maxPatients is less than or equal to 0.
     */
    public DiseaseControlManagerImpl(int maxDiseases, int maxPatients) {
        if (maxDiseases <= 0 || maxPatients <= 0) {
            throw new IllegalArgumentException("Maximum diseases and patients must be greater than 0.");
        }
        diseases = new Disease[maxDiseases];
        patients = new Patient[maxPatients];
        diseaseCount = 0;
        patientCount = 0;
    }

    
    /**
     * Adds a disease to the disease database.
     *
     * @param name       The name of the disease.
     * @param infectious A boolean indicating whether the disease is infectious.
     * @return The newly added Disease instance.
     * @throws IllegalStateException if the maximum capacity of diseases is reached.
     */
    @Override
    public Disease addDisease(String name, boolean infectious) {
        if (diseaseCount >= diseases.length) {
            throw new IllegalStateException("Cannot add more diseases. Maximum capacity reached.");
        }

        // Generate a new UUID for the disease
        UUID diseaseId = UUID.randomUUID();

        Disease newDisease;

        if (infectious) {
            newDisease = new InfectiousDisease(diseaseId, name);
        } else {
            newDisease = new NonInfectiousDisease(diseaseId, name);
        }

        diseases[diseaseCount++] = newDisease;
        return newDisease;
    }


    /**
     * Retrieves a disease by its unique identifier (UUID).
     *
     * @param diseaseId The UUID of the disease to retrieve.
     * @return The Disease instance with the specified UUID, or null if not found.
     */
    @Override
    public Disease getDisease(UUID diseaseId) {
        for (Disease disease : diseases) {
            if (disease != null && disease.getDiseaseId().equals(diseaseId)) {
                return disease;
            }
        }
        return null; // Disease not found
    }

    /**
     * Adds a new patient to the patient database.
     *
     * @param firstName    The first name of the patient.
     * @param lastName     The last name of the patient.
     * @param maxDiseases  The maximum number of diseases a patient can have.
     * @param maxExposures The maximum number of exposures a patient can have.
     * @return The newly added Patient instance.
     * @throws IllegalStateException if the maximum capacity of patients is reached.
     */
    @Override
    public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
        if (patientCount >= patients.length) {
            throw new IllegalStateException("Cannot add more patients. Maximum capacity reached.");
        }

        Patient newPatient = new Patient(maxDiseases, maxExposures);
        patients[patientCount++] = newPatient;
        return newPatient;
    }

    /**
     * Retrieves a patient by their unique identifier (UUID).
     *
     * @param patientId The UUID of the patient to retrieve.
     * @return The Patient instance with the specified UUID, or null if not found.
     */
    @Override
    public Patient getPatient(UUID patientId) {
        for (Patient patient : patients) {
            if (patient != null && patient.getPatientId().equals(patientId)) {
                return patient;
            }
        }
        return null; // Patient not found
    }

    /**
     * Adds a disease to a patient's list of diseases.
     *
     * @param patientId The UUID of the patient.
     * @param diseaseId The UUID of the disease to add to the patient.
     * @throws IllegalArgumentException if the patient or disease is not found.
     */
    @Override
    public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {
        Patient patient = null;
        Disease disease = null;

        // Retrieve the patient and disease
        for (Patient p : patients) {
            if (p != null && p.getPatientId() != null && p.getPatientId().equals(patientId)) {
                patient = p;
                break;
            }
        }

        for (Disease d : diseases) {
            if (d != null && d.getDiseaseId() != null && d.getDiseaseId().equals(diseaseId)) {
                disease = d;
                break;
            }
        }

        if (patient == null) {
            throw new IllegalArgumentException("Patient not found.");
        }

        if (disease == null) {
            throw new IllegalArgumentException("Disease not found.");
        }

        // Add the disease to the patient
        patient.addDiseaseId(disease.getDiseaseId());
    }


    /**
     * Adds an exposure to a patient's list of exposures.
     *
     * @param patientId The UUID of the patient.
     * @param exposure   The Exposure instance to add to the patient.
     * @throws IllegalArgumentException if the patient is not found.
     */
    @Override
    public void addExposureToPatient(UUID patientId, Exposure exposure) {
        Patient patient = null;

        // Retrieve the patient
        for (Patient p : patients) {
            if (p != null && p.getPatientId().equals(patientId)) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            throw new IllegalArgumentException("Patient not found.");
        }

        // Add the exposure to the patient
        patient.addExposure(exposure);
    }
}
