/**
 * The CustomList interface provides methods to manage a custom list containing elements of type T.
 *
 * @param <T> the type of elements in the list
 */
public interface CustomList<T> {

    /**
     * Returns the number of elements in the data structure.
     *
     * @return the number of elements in the data structure
     */
    public int size();

    /**
     * Returns true if the data structure contains no elements, false otherwise.
     *
     * @return true if the data structure contains no elements, false otherwise
     */
    public boolean isEmpty();

    /**
     * Adds the specified value to the data structure.
     *
     * @param value the value to be added to the data structure
     */
    public void add(T value);

    /**
     * Inserts the specified value at the specified position in the data structure.
     *
     * @param index the index at which the value should be inserted
     * @param value the value to be inserted into the data structure
     */
    public void add(int index, T value);

    /**
     * Removes and returns the value from the data structure at the current position.
     *
     * @return the value removed from the data structure
     */
    public T remove();

    /**
     * Removes and returns the value from the data structure at the specified index.
     *
     * @param index the index at which the value should be removed
     * @return the value removed from the data structure
     */
    public T remove(int index);

    /**
     * Retrieves and returns the value from the data structure.
     *
     * @return the value from the data structure
     */
    public T get();

    /**
     * Retrieves and returns the value from the data structure at the specified index.
     *
     * @param index the index of the value to retrieve
     * @return the value from the data structure at the specified index
     */
    public T get(int index);

    /**
     * Searches for the specified value in the data structure and returns the index of the first occurrence, if found.
     *
     * @param value the value to search for in the data structure
     * @return the index of the first occurrence of the specified value in the data structure, or -1 if not found
     */
    public int search(T value);

    /**
     * Checks whether the data structure contains the specified value.
     *
     * @param value the value to check for in the data structure
     * @return true if the data structure contains the specified value, false otherwise
     */
    public boolean contains(T value);

}