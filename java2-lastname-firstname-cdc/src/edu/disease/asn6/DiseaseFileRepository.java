package edu.disease.asn6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import edu.disease.asn3.Disease;

/**
 * The {@code DiseaseFileRepository} class provides methods for saving and initializing Disease and Patient data using serialization.
 */
public class DiseaseFileRepository {
    /**
     * The file path for storing Disease data.
     */
    private String Diseasefile;

    /**
     * The file path for storing Patient data.
     */
    private String Patientfile;

    /**
     * Saves the provided Disease and Patient arrays to files using serialization.
     *
     * @param disease The array of Disease objects to be saved.
     * @param patient The array of Patient objects to be saved.
     * @throws Exception if an error occurs during serialization or if file paths are not set.
     */
    public void save(List<Disease> disease, List<Patient> patient) throws Exception {
        if (Diseasefile == null || Patientfile == null) {
            throw new IllegalArgumentException("The file paths are empty");
        } else {
            FileOutputStream fl = new FileOutputStream(Diseasefile);
            FileOutputStream f2 = new FileOutputStream(Patientfile);
            ObjectOutputStream of = new ObjectOutputStream(fl);
            of.writeObject(disease);
            ObjectOutputStream od = new ObjectOutputStream(f2);
            od.writeObject(patient);
        }
    }

    /**
     * Initializes Disease and Patient data from serialized files.
     *
     * @param folderPath The folder path where the serialized files are located.
     * @return A DiseaseAndPatient instance containing initialized Disease and Patient arrays.
     * @throws Exception if an error occurs during deserialization or if file paths are not set.
     */
    public DiseaseAndPatient init(String folderPath) throws Exception {
        this.Diseasefile = folderPath + "diseases.dat";
        this.Patientfile = folderPath + "Patient.dat";
        DiseaseAndPatient dp = null;
        if (Diseasefile == null || Patientfile == null) {
            throw new IllegalArgumentException("The file paths are empty");
        } else {
            FileInputStream fl = new FileInputStream(Diseasefile);
            FileInputStream f2 = new FileInputStream(Patientfile);
            ObjectInputStream of = new ObjectInputStream(fl);
            List<Disease> d = (List<Disease>) of.readObject();
            ObjectInputStream od = new ObjectInputStream(f2);
            List<Patient> p = (List<Patient>) od.readObject();
            dp = new DiseaseAndPatient();
            dp.setDiseases(d);
            dp.setPatients(p);
        }
        return dp;
    }
}
