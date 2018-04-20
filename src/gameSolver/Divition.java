package gameSolver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${gaboq} on 19/4/2018.
 */

public class Divition {

    HashMap numbers;
    ArrayList<Integer> numArray;

    public Divition(HashMap nums) {
        numbers = (nums);
        numArray = new ArrayList<>(numbers.keySet());
    }

    public ArrayList<int[]> div(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < numArray.size(); i++) {
            for (int j = 0; j < numArray.size(); j++) {
                if (i / j == target) {
                    if (numArray.get(i) == numArray.get(j)) {
                        continue;
                    }
                    int[] array = {numArray.get(i), numArray.get(j)};
                    result.add(array);
                }
            }
        }
        return result;
    }

}
