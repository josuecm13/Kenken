package backtrack;

/**
 * Created by ${gaboq} on 15/4/2018.
 */
public class Tree {

    Node root;

    public Tree() {
        this.root = null;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            Node newN = addRecursive(current.left, value);
            current.left = newN;
            newN.right = current;
        } else if (value > current.value) {
            Node newN = addRecursive(current.right, value);
            current.right = newN;
            newN.left = current;
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    public void dfs(Node node) {
        if (node != null) {
            dfs(node.left);
            System.out.print(" " + node.value);
            dfs(node.right);
        }
    }

}
