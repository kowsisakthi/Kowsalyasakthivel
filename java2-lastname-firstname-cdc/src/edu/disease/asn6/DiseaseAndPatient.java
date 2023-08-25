package edu.disease.asn6;

import java.util.List;

import edu.disease.asn3.Disease;

/**
 * The {@code DiseaseAndPatient} class represents a container for arrays of Disease and Patient objects.
 * It provides methods to access and modify these arrays.
 */
public class DiseaseAndPatient {
    /**
     * An List to store Disease objects.
     */
    private List<Disease> diseases;

    /**
     * An List to store Patient objects.
     */
    private List<Patient> patients;

    /**
     * Gets the List of Disease objects stored in this container.
     *
     * @return The List of Disease objects.
     */
    public List<Disease> getDiseases() {
        return diseases;
    }

    /**
     * Sets the List of Disease objects in this container.
     *
     * @param diseases The List of Disease objects to set.
     */
    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    /**
     * Gets the List of Patient objects stored in this container.
     *
     * @return The List of Patient objects.
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Sets the List of Patient objects in this container.
     *
     * @param patients The List of Patient objects to set.
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}

