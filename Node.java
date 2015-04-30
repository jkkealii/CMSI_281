public class Node {
    String value;
    Node left;
    Node right;

    public Node () {
        value = null;
        left = null;
        right = null;
    }

    public Node (String input) {
        value = input;
        left = null;
        right = null;
    }

    public Node (String input, Node leftChild, Node rightChild) {
        value = input;
        left = leftChild;
        right = rightChild;
    }

}