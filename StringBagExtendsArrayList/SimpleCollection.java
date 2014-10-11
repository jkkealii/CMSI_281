/** This interface specifies a subset of the behaviors of java.util.Collection. For 
    additional details about the methods, refer to the documentation for that 
    interface. */
public interface SimpleCollection {

    /** Ensures that this collection contains the specified element (optional operation). */
    public boolean add ( Object o );
    
    /** Removes all of the elements from this collection (optional operation). */
    public void clear();
    
    /** Returns true if this collection contains the specified element. */
    public boolean contains ( Object o );
    
    /** Returns true if this collection contains no elements. */
    public boolean isEmpty();
    
    /** Removes a single instance of the specified element from this collection, if it is present. */
    public boolean remove ( Object o );
    
    /** Returns the number of elements in this collection. */
    public int size();
    
    /** Returns an array containing all of the elements in this collection. */
    public Object[] toArray();

}