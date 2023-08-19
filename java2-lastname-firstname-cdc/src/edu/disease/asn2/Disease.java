package edu.disease.asn2;

import java.util.UUID;

/**
 * The Disease class represents a disease entity with a unique identifier and a
 * name.
 */
public abstract class Disease {
	UUID diseaseId;
	String name;

	public UUID getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(UUID diseaseId) {
		this.diseaseId = diseaseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disease other = (Disease) obj;
		if (diseaseId == null) {
			if (other.diseaseId != null)
				return false;
		} else if (!diseaseId.equals(other.diseaseId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diseaseId == null) ? 0 : diseaseId.hashCode());
		return result;
	}

	abstract String[] getExamples();
}

class InfectiousDisease extends Disease {
	@Override
	String[] getExamples() {
		String str[] = { "HIV", "Corona", "Malaria", "Typhoid" };
		return str;
	}

}

class NonInfectiousDisease extends Disease {
	@Override
	String[] getExamples() {
		String str[] = { "Diabetes", "Hypertension", "Cancer", "Alzheimer" };
		return str;
	}

}
