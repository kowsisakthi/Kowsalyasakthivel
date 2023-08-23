package edu.disease.asn4;

import java.time.LocalDateTime;

import edu.disease.asn3.Patient;
/**
 * The PatientZero class represents the first patient in a line of exposures.
 * It holds information about the patient, exposure date and time, and exposure status.
 */
public class PatientZero {
    private Patient patient;
    private LocalDateTime exposureDateTime;
    private boolean exposed;

    /**
     * Get the associated patient for this patient zero.
     *
     * @return The associated patient.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Set the associated patient for this patient zero.
     *
     * @param patient The patient to associate with this patient zero.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Get the date and time of exposure for this patient zero.
     *
     * @return The date and time of exposure.
     */
    public LocalDateTime getExposureDateTime() {
        return exposureDateTime;
    }

    /**
     * Set the date and time of exposure for this patient zero.
     *
     * @param exposureDateTime The date and time of exposure.
     */
    public void setExposureDateTime(LocalDateTime exposureDateTime) {
        this.exposureDateTime = exposureDateTime;
    }

    /**
     * Check if this patient zero is exposed.
     *
     * @return True if the patient zero is exposed, false otherwise.
     */
    public boolean isExposed() {
        return exposed;
    }

    /**
     * Set the exposure status for this patient zero.
     *
     * @param exposed The exposure status to set (true if exposed, false otherwise).
     */
    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }
}

