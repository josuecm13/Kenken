package gameSolver;

import java.util.ArrayList;

/**
 * Created by ${gaboq} on 19/4/2018.
 */

public class Operate {

    private ArrayList<Integer> numArray;

    public Operate(ArrayList<Integer> numArray) {
        this.numArray = numArray;
    }

    public ArrayList<int[]> permutateOne(int target) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        int[] result = {(int) Math.cbrt(target)};
        arrayList.add(result);
        return arrayList;
    }

    public ArrayList<int[]> permutateTwo(String operation, int target) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < (numArray.size()); i++) {
            for (int j = 0; j < (numArray.size()); j++) {
                if (numArray.get(i) == numArray.get(j)) {
                    continue;
                }
                switch (operation) {
                    case "+":
                        if (numArray.get(i) + numArray.get(j) == target) {
                            int[] array = {numArray.get(i), numArray.get(j)};
                            result.add(array);
                        }
                        break;
                    case  "-":
                        if (numArray.get(i) - numArray.get(j) == target) {
                            int[] array = {numArray.get(i), numArray.get(j)};
                            result.add(array);
                        }
                        break;
                    case "x":
                        if (numArray.get(i) * numArray.get(j) == target) {
                            int[] array = {numArray.get(i), numArray.get(j)};
                            result.add(array);
                        }
                        break;
                    case "÷":
                        if (!(numArray.get(j) == 0)) {
                            if (numArray.get(i) / numArray.get(j) == target) {
                                int[] array = {numArray.get(i), numArray.get(j)};
                                result.add(array);
                            }
                        }
                        break;
                    case  "%":
                        if (!(numArray.get(j) == 0)) {
                            if (numArray.get(i) % numArray.get(j) == target) {
                                int[] array = {numArray.get(i), numArray.get(j)};
                                result.add(array);
                            }
                        }
                        break;
                }
            }
        }
        return result;
    }

    public ArrayList<int[]> permutateThree(String operation, int target){
        ArrayList<int[]> result = new ArrayList<>();
        for (int  i = 0; i < numArray.size(); i++) {
            for (int j = 0; j < numArray.size(); j++) {
                for (int k = 0; k < numArray.size(); k++) {
                    if (numArray.get(i) == numArray.get(j) || numArray.get(j) == numArray.get(k)) {
                        continue;
                    }
                    switch (operation) {
                        case "+":
                            if (numArray.get(i) + numArray.get(j) + numArray.get(k) == target) {
                                int[] array = {numArray.get(i), numArray.get(j), numArray.get(k)};
                                result.add(array);
                            }
                            break;
                        case  "-":
                            if (numArray.get(i) - numArray.get(j) - numArray.get(k) == target) {
                                int[] array = {numArray.get(i), numArray.get(j), numArray.get(k)};
                                result.add(array);
                            }
                            break;
                        case "x":
                            if (numArray.get(i) * numArray.get(j) * numArray.get(k) == target) {
                                int[] array = {numArray.get(i), numArray.get(j), numArray.get(k)};
                                result.add(array);
                            }
                            break;
                    }

                }
            }
        }
        return result;
    }

    public ArrayList<int[]> permutateFour(String operation, int target){
        ArrayList<int[]> result = new ArrayList<>();
        for (int  i = 0; i < numArray.size(); i++) {
            for (int j = 0; j < numArray.size(); j++) {
                for (int k = 0; k < numArray.size(); k++) {
                    for (int l = 0; l < numArray.size(); l++) {
                        if (numArray.get(i) == numArray.get(j) || numArray.get(j) == numArray.get(k)
                                || numArray.get(k) == numArray.get(l) || numArray.get(l) == numArray.get(i)) {
                            continue;
                        }
                        switch (operation) {
                            case "+":
                                if (numArray.get(i) + numArray.get(j) + numArray.get(k) + numArray.get(l) == target) {
                                    int[] array = {numArray.get(i), numArray.get(j), numArray.get(k), numArray.get(l)};
                                    result.add(array);
                                }
                                break;
                            case "-":
                                if (numArray.get(i) - numArray.get(j) - numArray.get(k) - numArray.get(l) == target) {
                                    int[] array = {numArray.get(i), numArray.get(j), numArray.get(k), numArray.get(l)};
                                    result.add(array);
                                }
                                break;
                            case "x":
                                if (numArray.get(i) * numArray.get(j) * numArray.get(k) * numArray.get(l) == target) {
                                    int[] array = {numArray.get(i), numArray.get(j), numArray.get(k), numArray.get(l)};
                                    result.add(array);
                                }
                                break;
                        }
                    }
                }
            }
        }
        return result;
    }

}
