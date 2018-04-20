package gameSolver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${gaboq} on 19/4/2018.
 */

public class Addition {

    HashMap numbers;
    ArrayList<Integer> numArray;

    public Addition(HashMap nums) {
        numbers = (nums);
        numArray = new ArrayList<>(numbers.keySet());
    }

    public ArrayList<Integer> sum(int target, int len) {
        ArrayList<int[]> r = sumPermut(target, len);
        return null;
    }

    private ArrayList<int[]> sumPermut(int target, int len) {
        ArrayList<int[]> result = null;
        if (numbers.size() < 11) {
            switch (len) {
                case 2:
                    result = sumPermut2(target);
                    break;
                case 3:
                    result = sumPermut3(target);
                    break;
                case 4:
                    result = sumPermut4(target);
                    break;
            }
        } else {
            // Si hay negativos
        }
        return result;
    }

//return arr.subList(0, N);

    private ArrayList<int[]> sumPermut2(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < (numArray.size()); i++) {
            for (int j = 0; j < (numArray.size()); j++) {
                if (numArray.get(i) + numArray.get(j) == target) {
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


    private ArrayList<int[]> sumPermut3(int target){
        ArrayList<int[]> result = new ArrayList<>();
        for (int  i = 0; i < numArray.size(); i++) {
            for (int j = 0; j < numArray.size(); j++) {
                for (int k = 0; k < numArray.size(); k++) {
                    if (numArray.get(i) + numArray.get(j) + numArray.get(k) == target) {
                        if (numArray.get(i) == numArray.get(j) || numArray.get(j) == numArray.get(k)) {
                            continue;
                        }
                        int[] array = {numArray.get(i), numArray.get(j), numArray.get(k)};
                        result.add(array);
                    }
                }
            }
        }
        return result;
    }

    private ArrayList<int[]> sumPermut4(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int  i = 0; i < numArray.size(); i++) {
            for (int j = 0; j < numArray.size(); j++) {
                for (int k = 0; k < numArray.size(); k++) {
                    for (int l = 0; l < numArray.size(); l++) {
                        if (numArray.get(i) + numArray.get(j) + numArray.get(k) + numArray.get(l) == target) {
                            if (numArray.get(i) == numArray.get(j) || numArray.get(j) == numArray.get(k)
                                    || numArray.get(k) == numArray.get(l) || numArray.get(l) == numArray.get(i)) {
                                continue;
                            }
                            int[] array = {numArray.get(i), numArray.get(j), numArray.get(k), numArray.get(l)};
                            result.add(array);
                        }
                    }
                }
            }
        }
        return result;
    }

}
