package backtrack;

/**
 * Created by ${gaboq} on 15/4/2018.
 */
public class Tree {

    public Tree up;
    public Tree down;
    public Tree left;
    public Tree rigth;
    public boolean use;

    public Tree() {
        up = null;
        down = null;
        left = null;
        rigth = null;
        use = false;
    }

}
