//
//  Name:       Kwan, Wesley
//  Project:    2
//  Due:        03/07/20
//  Course:     cs-2400-02
//
//  Description:
//              Interface of the stack ADT.
//
public interface StackInterface<T>
{
    /**
     * Pushes a new entry onto the top of this stack.
     * @param newEntry the object to be pushed onto this stack
     */
    public void push(T newEntry);
    /**
     * Looks at the top entry of this stack without
     * removing it from the stack.
     * @return  the object at the top of this stack
     */
    public T peek();
    /**
     * Removes the top entry of this stack.
     * @return                  the object at the top of this stack
     * @throws RuntimeException if the stack is empty
     */
    public T pop();
    /**
     * Checks whether this stack is empty.
     * @return  true if the stack is empty, false if not
     */
    public boolean isEmpty();
    /**
     * Removes all entries from this stack.
     */
    public void clear();
}
