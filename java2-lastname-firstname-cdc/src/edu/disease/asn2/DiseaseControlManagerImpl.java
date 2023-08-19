package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public class DiseaseControlManagerImpl implements DiseaseControlManager {
	private Disease[] diseases;
	private Patient[] patients;
	int md, me, indexd = 0, indexp = 0;

	public DiseaseControlManagerImpl(int maxDiseases, int maxPatient) {
		if (maxDiseases <= 0 || maxPatient <= 0) {
			throw new IllegalArgumentException("Invalid Data");
		} else {
			diseases = new Disease[maxDiseases];
			patients = new Patient[maxPatient];
		}
	}

	@Override
	public Disease addDisease(String name, boolean infectious) {

		if (md <= indexd) {
			throw new IllegalStateException("No more Disease can be added");
		} else {
			if (infectious) {
				return diseases[indexd++] = new InfectiousDisease();
			} else {
				return diseases[indexd++] = new NonInfectiousDisease();
			}
		}
	}

	@Override
	public Disease getDisease(UUID diseaseld) {
		for (Disease d : diseases) {
			if (d.getDiseaseId() == diseaseld) {
				return d;
			}
		}
		return null;

	}

	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		if (me <= indexp) {
			throw new IllegalStateException("No more Patients can be added");
		} else {
			patients[indexp]=new Patient(maxDiseases, maxExposures);
			patients[indexp].setLastName(lastName);
			patients[indexp].setFirstName(firstName);
			return patients[indexp++];
		}
	}

	@Override
	public Patient getPatient(UUID patientld) {
		for (Patient pa : patients) {
			if (pa.getPatientId() == patientld) {
				return pa;
			}
		}
		return null;
	}

	@Override
	public void addDiseaseToPatient(UUID patientld, UUID diseaseld) {
		Disease ds = null;
		Patient ps = null;
		int dg = 0, pg = 0;
		for (Disease d : diseases) {
			if (d.getDiseaseId() == diseaseld) {
				ds = d;
				dg = 1;
			}
		}
		if (dg == 0) {
			throw new IllegalArgumentException("Disease not Found");
		}
		for (Patient p : patients) {
			if (p.getPatientId() == patientld) {
				ps = p;
				pg = 1;
			}
		}
		if (pg == 0) {
			throw new IllegalArgumentException("Patient not Found");
		}
		if (dg == 1 && pg == 1) {
			ps.addDiseaseId(ds.getDiseaseId());
		}

	}

	

	@Override
	public void addExposureToPatient(UUID patientld, Exposure exposure) {
		int pg = 0;
		Patient ps = null;
		for (Patient p : patients) {
			if (p.getPatientId()== patientld) {
				ps = p;
				pg = 1;
			}
		}
		if (pg == 0) {
			throw new IllegalArgumentException("Patient not Found");
		} else {
			ps.addExposusre(exposure);
		}
	}

}
