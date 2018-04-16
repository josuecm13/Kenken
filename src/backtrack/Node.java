package backtrack;

/**
 * Created by ${gaboq} on 15/4/2018.
 */

public class Node {

    public Node up;
    public Node down;
    public Node left;
    public Node right;
    public int value;
    public boolean visited;

    public Node(int value) {
        this.value = value;
        up = null;
        down = null;
        left = null;
        right = null;
        visited = false;
    }

}
