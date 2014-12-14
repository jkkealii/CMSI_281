import java.util.*;

public class BTreeIterator implements Iterator {
    private BinaryTree following;
    private BinaryTree present;
    private Stack<BinaryTree> mound;

    public BTreeIterator (BinaryTree bTree) {
        this.following = bTree;
        this.mound = new Stack<BinaryTree>();
        this.present = null;
    }

    public boolean hasNext () {
        if (this.present == null) {
            return this.following != null;
        } else if (this.present.left3 != null) {
            return true;
        } else if (!this.mound.empty()) {
            return true;
        }
        return false;
    }

    public Object next () {
        Object result;
        if (this.present == null) {
            result = this.following.rootNode;
        } else if (this.present.left3 != null) {
            result = this.present.left3;
        } else if (!this.mound.empty()) {
            result = this.mound.pop();
        } else {
            return null;
        }
        if (this.present.right3 != null) {
            this.mound.push(this.present.right3);
        }
        return null;
    }

    public void remove () {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}