import java.util.*;

public class BinaryTree implements Collection {
    Object rootNode = null;
    BinaryTree left3 = null;
    BinaryTree right3 = null;
    int length = 0;

    public BinaryTree () {
        //properties already initialized
    }

    public BinaryTree (Object root) {
        this.rootNode = root;
        if (this.rootNode != null) {
            this.length = 1;
        }
    }

    public BinaryTree (Object root, BinaryTree left, BinaryTree right) {
        this.rootNode = root;
        this.left3 = left;
        this.right3 = right;
        if (this.rootNode != null) {
            this.length = 1;
        }
        if (this.left3 != null) {
            this.length += this.left3.length;
        }
        if (this.right3 != null) {
            this.length += this.right3.length;
        }
    }
    
    public boolean add (Object addend) {
        if (addend == null) {
            return false;
        }
        if (this.rootNode == null) {
            this.rootNode = addend;
            this.length++;
            return true;
        } else if (this.left3 != null) {
            if (this.left3.add(addend)) {
                this.length++;
                return true;
            }
        } else {
            this.left3 = new BinaryTree(addend);
            this.length++;
            return true;
        }
        return false;
    }

    public static BinaryTree createFromData (Object rootData, BinaryTree leftSubtree, BinaryTree rightSubtree) {
        BinaryTree creation = new BinaryTree (rootData, leftSubtree, rightSubtree);
        return creation;
    }

    public Iterator iterator () {
        return new BTreeIterator(this);
    }

    public void clear () {
        this.rootNode = null;
        this.left3 = null;
        this.right3 = null;
        this.length = 0;
    }

    public boolean containsAll (Collection c) {
        throw new UnsupportedOperationException();
    }

    public boolean equals (Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean remove (Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll (Collection c) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll (Collection c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll (Collection c) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray () {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray (Object[] a) {
        throw new UnsupportedOperationException();
    }

    public boolean contains (Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty () {
        throw new UnsupportedOperationException();
    }

    public int size () {
        throw new UnsupportedOperationException();
    }
}
