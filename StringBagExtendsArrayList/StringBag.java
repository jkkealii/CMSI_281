import java.util.ArrayList;

public class StringBag extends ArrayList implements SimpleCollection {

    public StringBag () {
        super();
    }

    public StringBag (String wordle) {
        super();
        super.add(wordle);
    }

    public StringBag (String[] words) {
        super();
        for (int i = 0; i < words.length; i++) {
            super.add(words[i]);
        }
    }

    /** Ensures that this collection contains the specified element (optional operation). */
    public boolean add ( Object o ) {
        if (o instanceof String) {
            return super.add(o);
        }
        return false;
    }
    
    /** Removes all of the elements from this collection (optional operation). */
    public void clear() {
        super.clear();
    }
    
    /** Returns true if this collection contains the specified element. */
    public boolean contains ( Object o ) {
        return super.contains(o);
    }
    
    /** Returns true if this collection contains no elements. */
    public boolean isEmpty() {
        return super.isEmpty();
    }
    
    /** Removes a single instance of the specified element from this collection, if it is present. */
    public boolean remove ( Object o ) {
       if (o instanceof String) {
            return super.remove(o);
        }
        return false;
    }
    
    /** Returns the number of elements in this collection. */
    public int size() {
        return super.size();
    }
    
    /** Returns an array containing all of the elements in this collection. */
    public Object[] toArray() {
        return super.toArray();
    }
    //for testing
    
    public String toString() {
        return super.toString();
    }

    //TESTER MAIN METHOD
    public static void main(String[] args) {
        StringBag theBag = new StringBag(args);
        System.out.println("size: " + theBag.size());
        System.out.println("empty? " + theBag.isEmpty());
        System.out.println("contains \"josh\": " + theBag.contains("josh"));
        System.out.println(theBag);
        System.out.println("add \"dorin\": " + theBag.add("dorin"));
        System.out.println(theBag);
        System.out.println("remove \"josh\": " + theBag.remove("josh"));
        System.out.println(theBag);
        System.out.println("cleared");
            theBag.clear();
        System.out.println(theBag);
    }
}