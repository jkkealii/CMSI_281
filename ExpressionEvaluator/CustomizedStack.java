public class CustomizedStack {
    private CustomizedStack following;
    private String term;
    private int length;

    //constructor that returns the input
    public CustomizedStack (CustomizedStack input) {
        this.term = input.term;
        this.following = input.following;
        this.length = input.length;
    }

    //constructor for 1-element list
    public CustomizedStack (String term) {
        this.term = term;
        this.following = null;
        this.length = 1;
    }

    //push 1-element list (above) onto the stack
    public void push (CustomizedStack another) {
        CustomizedStack current = this; //create variable to store pointer to this stack

        while (current.following != null) { //while we are not at the last node
            current = current.following; //go further down the line
        }

        current.following = another; //now we are at the last node, so replace null with another
        this.length += 1;
    }

    //remove the last element (stack) from the stack & changes this.length
    public void remove () {
        CustomizedStack current = this;
        CustomizedStack previous = this;

        while (current.following != null) { //get to the last node
            previous = current;
            current = current.following;
        }
        //current = null; //once you are at the last node, set to null (in essence, removing it)
        previous.following = null; //sets the following pointer to null

        this.length -= 1;
    }

    //popping the last two values out of the stack
    public int[] pop () {
        int[] popped = new int[2];
        CustomizedStack current = this;
        
        if (this.length < 2) { //if the stack is not yet large enough, exception
            throw new IllegalArgumentException("Unpoppable stack");
        } else {
            //find the last two values and place them into the int[] popped
            for (int i = 1; i >= 0; i--) {
                while (current.following != null) {
                    current = current.following;
                }
                popped[i] = Integer.parseInt(current.term);
                current = this; //reset current to this
                current.remove(); //remove the last value that was popped
            }
        }
        return popped;
    }

    public String toString() {
        return this.term;
    }
}