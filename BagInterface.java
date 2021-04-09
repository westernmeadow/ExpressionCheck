//
//  Name:       Kwan, Wesley
//  Project:    2
//  Due:        03/07/20
//  Course:     cs-2400-02
//
//  Description:
//              Interface of the bag ADT.
//
public interface BagInterface<T> {
    /**
     * Gets the current number of entries in this bag.
     * @return  the integer number of entries currently in the bag
     */
    public int getCurrentSize();
    /**
     * Checks whether this bag is empty.
     * @return  true if the bag is empty, false if not
     */
    public boolean isEmpty();
    /**
     * Adds a new entry to this bag.
     * @param newEntry the object to be added as a new entry
     * @return         true if the addition is successful, or false if not
     */
    public boolean add(T newEntry);
    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return either the removed entry, if removal was successful, or null
     */
    public T remove();
    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * @param anEntry the entry to be removed
     * @return        true if the removal was successful, or false if not
     */
    public boolean remove(T anEntry);
    /**
     * Removes all entries from this bag.
     */
    public void clear();
    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry the entry to be counted.
     * @return        the number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry);
    /**
     * Tests wheter this bag contains a given entry.
     * @param anEntry the entry to find
     * @return        true if the bag contains anEntry, or false if not
     */
    public boolean contains(T anEntry);
    /**
     * Retrieves all entries that are in this bag.
     * @return a newly allocated array of all the entries in the bag
     */
    public T[] toArray();
}