package edu.disease.asn5;

/**
 * A generic container class that stores an array of objects of type T.
 *
 * @param <T> The type of objects to be stored in the container.
 */
public class Container<T> {
    private T[] object;

    /**
     * Constructs a Container with the provided objects.
     *
     * @param object The objects to be stored in the container.
     * @throws IllegalArgumentException if no arguments are provided.
     */
    public Container(T... object) {
        if (object.length == 0) {
            throw new IllegalArgumentException("No arguments provided.");
        }
        this.object = object;
    }

    /**
     * Returns the number of elements in the container.
     *
     * @return The number of elements in the container.
     */
    public int size() {
        return object.length;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    public T get(int index) {
        if (index >= object.length || index < 0) {
            throw new IllegalArgumentException("Invalid index.");
        }
        return object[index];
    }
}
