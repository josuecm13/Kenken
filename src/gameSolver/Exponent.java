package gameSolver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${gaboq} on 19/4/2018.
 */
public class Exponent {

    HashMap numbers;
    ArrayList<Integer> numArray;

    public Exponent(HashMap nums) {
        numbers = (nums);
        numArray = new ArrayList<>(numbers.keySet());
    }

    public int exp(int target) {
        int result = (int) Math.cbrt(target);
        return result;
    }

}
