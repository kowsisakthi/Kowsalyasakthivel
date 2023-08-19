package edu.disease.asn1;

import java.util.UUID;

/**
 * The Disease class represents a disease entity with a unique identifier and a name.
 */
public class Disease {
    /** The unique identifier for the disease. */
    UUID diseaseId;

    /** The name of the disease. */
    String name;

    /**
     * Gets the unique identifier for the disease.
     *
     * @return The UUID representing the disease's identifier.
     */
    public UUID getDiseaseId() {
        return diseaseId;
    }

    /**
     * Sets the unique identifier for the disease.
     *
     * @param diseaseId The UUID to set as the disease's identifier.
     */
    public void setDiseaseId(UUID diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * Gets the name of the disease.
     *
     * @return The name of the disease.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the disease.
     *
     * @param name The name to set for the disease.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compares this disease object to another object for equality.
     * Two diseases are considered equal if they have the same diseaseId.
     *
     * @param obj The object to compare for equality.
     * @return true if the objects are equal, false otherwise.
     */
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

    /**
     * Generates a hash code value for this disease object.
     *
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((diseaseId == null) ? 0 : diseaseId.hashCode());
        return result;
    }

    /**
     * Generates a string representation of the disease object.
     *
     * @return A string containing diseaseId and name information.
     */
    @Override
    public String toString() {
        return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
    }
}
