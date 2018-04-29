package gameSolver;

import gameboard.logic.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<int[]> shapePodeTwo(Shape shape, ArrayList<int[]> shapes) {
        List<int[]> toRemove = new ArrayList();
        for (int[] array : shapes) {
            if (array[0] == array[1]) {
                shapes.remove(array);
            }
        }
        shapes.removeAll(toRemove);
        return shapes;
    }

    public ArrayList<int[]> shapePodeFour(Shape shape, ArrayList<int[]> shapes) {
        if (shape.toString() != "T" || shape.toString() != "L") {
            List<int[]> toRemove = new ArrayList();
            for (int[] array : shapes) {
                if (array[0] == array[1] || array[2] == array[3]) {
                    toRemove.add(array);
                }
            }
            shapes.removeAll(toRemove);
            return shapes;
        }
        return shapes;
    }

}
