//
//  Name:       Kwan, Wesley
//  Project:    2
//  Due:        03/07/20
//  Course:     cs-2400-02
//
//  Description:
//              Array implementation of BagInterface.
//
public final class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayBag(int desiredCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[desiredCapacity];
        bag = tempBag;
        numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }
    
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    public boolean add(T newEntry) {
        if (isArrayFull())
            return false;
        else
            bag[numberOfEntries++] = newEntry;
        return true;
    }
    
    public T remove() {
        return removeEntry(numberOfEntries -1);
    }
    
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index > -1) {
            T result = removeEntry(index);
            return anEntry.equals(result);
        }
        return false;
    }
    
    public void clear() {
        while (!isEmpty())
            remove();
    }
    
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index]))
                counter++;
        }
        return counter;
    }
    
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > -1;
    }
    
    public T[] toArray() {
        T[] result = (T[])new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++)
            result[index] = bag[index];
        return result;
    }
    
    private boolean isArrayFull() {
        return numberOfEntries == bag.length;
    }
    
    private int getIndexOf(T anEntry) {
        int index = 0;
        while (index < numberOfEntries) {
            if (anEntry.equals(bag[index]))
                return index;
            index++;
        }
        return -1;
    }
    
    private T removeEntry(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }
}