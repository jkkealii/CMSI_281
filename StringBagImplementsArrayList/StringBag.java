import java.util.ArrayList;

public class StringBag implements SimpleCollection {
    private ArrayList <String> array;

    public StringBag () {
        this.array = new ArrayList<String>();
    }

    public StringBag (String wordle) {
        this.array = new ArrayList<String>();
        this.array.add(wordle);
    }

    public StringBag (String[] words) {
        this.array = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            this.array.add(words[i]);
        }
    }

    /** Ensures that this collection contains the specified element (optional operation). */
    public boolean add ( Object o ) {
        if (o instanceof String) {
            return this.array.add((String)o);
        }
        return false;
    }
    
    /** Removes all of the elements from this collection (optional operation). */
    public void clear() {
        this.array.clear();
    }
    
    /** Returns true if this collection contains the specified element. */
    public boolean contains ( Object o ) {
        return this.array.contains(o);
    }
    
    /** Returns true if this collection contains no elements. */
    public boolean isEmpty() {
        return this.array.isEmpty();
    }
    
    /** Removes a single instance of the specified element from this collection, if it is present. */
    public boolean remove ( Object o ) {
       if (o instanceof String) {
            return this.array.remove(o);
        }
        return false; 
    }
    
    /** Returns the number of elements in this collection. */
    public int size() {
        return this.array.size();
    }
    
    /** Returns an array containing all of the elements in this collection. */
    public Object[] toArray() {
        return this.array.toArray();
    }
    //for testing
    
    public String toString() {
        return this.array.toString();
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