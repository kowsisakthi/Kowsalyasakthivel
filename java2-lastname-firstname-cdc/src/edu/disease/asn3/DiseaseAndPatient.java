package edu.disease.asn3;

/**
 * The {@code DiseaseAndPatient} class represents a container for arrays of Disease and Patient objects.
 * It provides methods to access and modify these arrays.
 */
public class DiseaseAndPatient {
    /**
     * An array to store Disease objects.
     */
    private Disease[] diseases;

    /**
     * An array to store Patient objects.
     */
    private Patient[] patients;

    /**
     * Gets the array of Disease objects stored in this container.
     *
     * @return The array of Disease objects.
     */
    public Disease[] getDiseases() {
        return diseases;
    }

    /**
     * Sets the array of Disease objects in this container.
     *
     * @param diseases The array of Disease objects to set.
     */
    public void setDiseases(Disease[] diseases) {
        this.diseases = diseases;
    }

    /**
     * Gets the array of Patient objects stored in this container.
     *
     * @return The array of Patient objects.
     */
    public Patient[] getPatients() {
        return patients;
    }

    /**
     * Sets the array of Patient objects in this container.
     *
     * @param patients The array of Patient objects to set.
     */
    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }
}

