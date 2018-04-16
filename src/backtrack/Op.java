package backtrack;

import java.util.ArrayList;

/**
 * Created by ${gaboq} on 15/4/2018.
 */

public class Op {

    public static int sum(ArrayList<Integer> array) {
        int sum = 0;
        for(int d : array)
            sum += d;
        return sum;
    }

}
