public class CircularList {
    private Person proTem; //current node
    private int magnitude;

    public CircularList () { //constructing list with one member, name is zero
        this.proTem = new Person(0);
        this.magnitude = 1;
        this.proTem.next = this.proTem; //linking and penetrating his/herself
        this.proTem.previous = this.proTem;
    }

    public void add (int value) {
        Person caretaker = new Person(value); //make the new person.
        caretaker.next = this.proTem.next; //set next pointer to the original G
        caretaker.next.previous = caretaker; 
        this.proTem.next = caretaker;
        caretaker.previous = this.proTem;
        this.proTem = caretaker;
        this.magnitude++;
    }

    public void remove () {
        this.proTem.previous.next = this.proTem.next;
        this.proTem.next.previous = this.proTem.previous;
        this.proTem = this.proTem.next;
        this.magnitude--;
    }

    public void flounder () {
        this.proTem = this.proTem.next;
    }

    public String inoa () {
        return this.proTem.getName();
    }

    public int getMagnitude () {
        return this.magnitude;
    }
}