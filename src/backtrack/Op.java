package backtrack;

import java.util.ArrayList;


public class Op {

    public static int sum(ArrayList<Integer> array) {
        int sum = 0;
        for(int d : array)
            sum += d;
        return sum;
    }

}
