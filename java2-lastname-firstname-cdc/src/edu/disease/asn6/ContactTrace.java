package edu.disease.asn6;

import java.util.Arrays;
import java.util.List;

import edu.disease.asn3.DiseaseControlManager;
import edu.disease.asn3.Exposure;
import edu.disease.asn3.Patient;
import edu.disease.asn4.PatientZero;

/**
 * The ContactTrace class is responsible for finding the first patient (Patient Zero)
 * in a line of exposures based on certain conditions. It utilizes exposure data from
 * patients to determine the first exposure of a specific type before a given date and time.
 */
public class ContactTrace {
    private static List <Patient> pa;
    private PatientZero patientobj;

    /**
     * Creates a ContactTrace instance using the provided DiseaseControlManager.
     *
     * @param diseaseControlManager The DiseaseControlManager instance providing patient data.
     */
    public ContactTrace(DiseaseControlManager diseaseControlManager) {
        this.pa = Arrays.asList(diseaseControlManager.getPatient());
    }

    /**
     * Finds the patient zero (first exposure of a specific type before a given date and time)
     * for the given patient.
     *
     * @param patient The patient for which to find the patient zero.
     * @return The PatientZero instance representing the patient zero, or null if not found.
     */
    public PatientZero findPatientZero(Patient patient) {
        for (Exposure exopsure : patient.getExposures()) {
            if (exopsure.getExposureType().equals("D")) {
                for (Patient p : pa) {
                    for (Exposure e : p.getExposures()) {
                        if (e.getExposureType().equals("D")) {
                            if (exopsure.getDateTime().isBefore(e.getDateTime())) {
                                patientobj = new PatientZero();
                                patientobj.setExposureDateTime(e.getDateTime());
                                patientobj.setExposed(true);
                                return findPatientZero(p);
                            }
                        }
                    }
                }
            }
        }
        return patientobj;
    }
}
