//
//  Name:       Kwan, Wesley
//  Project:    2
//  Due:        03/07/20
//  Course:     cs-2400-02
//
//  Description:
//              Linked implementation of StackInterface.
//
public final class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode;
    
    public LinkedStack()
    {
        topNode = null;
    }
    
    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }
    
    public T peek() 
    { 
        if (isEmpty())
            throw new RuntimeException("Empty stack.");
        else
            return (T)topNode.data;
    }
    
    public T pop()
    {
        T top = peek();  // Might throw EmptyStackException
        // Assertion: topNode != null
        topNode = topNode.next;
        return top;
    }
    
    public boolean isEmpty()
    {
        return topNode == null;
    }
    
    public void clear()
    {
        //topNode = null;
        while (!isEmpty())
            pop();
    }
    
    private class Node<T>
    {
        private T data;
        private Node next;
        
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        
        private Node(T dataPortion, Node nextNode)
        { 
            data = dataPortion; 
            next = nextNode; 
        }
    }
}
