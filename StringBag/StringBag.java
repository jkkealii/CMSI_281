import java.lang.StringBuilder;

public class StringBag implements SimpleCollection {
    private Object[] array;
    private int firstEmpty;

    public StringBag () {
        this.array = new Object[8];
        this.firstEmpty = 0;
    }

    public StringBag (Object wordle) {
        this.array = new Object[8];
        this.array[0] = wordle;
        this.firstEmpty = 1;
    }

    public StringBag (Object[] words) {
        this.array = words.clone();
        this.firstEmpty = words.length;
    }

    /** Ensures that this collection contains the specified element (optional operation). */
    public boolean add ( Object o ) {
        if (this.firstEmpty >= this.array.length) {
            Object[] newArray = new Object[this.array.length * 2];
            for (int i = 0; i < this.array.length; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
        this.array[this.firstEmpty] = o;
        this.firstEmpty++;
        return true; 
    }
    
    /** Removes all of the elements from this collection (optional operation). */
    public void clear() {
        this.array = new Object[8];
        this.firstEmpty = 0;
    }
    
    /** Returns true if this collection contains the specified element. */
    public boolean contains ( Object o ) {
        for (int i = 0; i < this.firstEmpty; i++) {
            if (this.array[i].equals(o)) {
                return true;
            } 
        }
        return false;
    }
    
    /** Returns true if this collection contains no elements. */
    public boolean isEmpty() {
        return this.firstEmpty == 0;
    }
    
    /** Removes a single instance of the specified element from this collection, if it is present. */
    public boolean remove ( Object o ) {
        for (int i = 0; i < this.firstEmpty; i++) {
            if (this.array[i].equals(o)) {
                this.array[i] = this.array[this.firstEmpty-1];
                this.firstEmpty--;
                this.array[this.firstEmpty] = null;
                return true;
            }
        }
        return false;
    }
    
    /** Returns the number of elements in this collection. */
    public int size() {
        return this.firstEmpty;
    }
    
    /** Returns an array containing all of the elements in this collection. */
    public Object[] toArray() {
        Object[] aray = new Object[this.firstEmpty];
        for (int i = 0; i < this.firstEmpty; i++) {
            aray[i] = this.array[i];
        }
        return aray;
    }
    
    //for testing
    public String toString() {
        StringBuilder hugeString = new StringBuilder();
        hugeString.append("[ ");
        for (int i = 0; i < this.firstEmpty; i++) {
            hugeString.append("\"");
            hugeString.append(this.array[i]);
            hugeString.append("\"");
            if (i < this.array.length-1) {
                hugeString.append(" ");
            }
        }
        hugeString.append(" ]");
        return hugeString.toString();
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