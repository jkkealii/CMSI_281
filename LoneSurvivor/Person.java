public class Person {
    public Person previous;
    public Person next;
    public int name;

    public Person (int value) { //creating initial person at start of construction
        this.name = value;
        this.previous = null;
        this.next = null;
    }

    public Person (int value, Person before, Person after) {
        this.name = value;
        this.previous = before;
        this.next = after;
    }

    public Person (int value, Person before) { //creating persons after initial
        this.name = value;
        this.previous = before;
        this.next = null;
    }

    public String getName () {
        return Integer.toString(name);
    }

    public void remove () {
        this.previous.next = this.next;
        this.next.previous = this.previous;
    }
}