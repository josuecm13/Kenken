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

    public ArrayList<int[]> permutateFour(Shape shape, String operation, int target){
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
        shapePodeFour(shape, result);
        return result;
    }

    public ArrayList<int[]> shapePodeFour(Shape shape, ArrayList<int[]> shapes) {
        List<int[]> toRemove = new ArrayList();
        for (int[] array : shapes) {
            if ((shape.getID() != Shape.ShapeTypeID.TTYPE ) && (shape.getID() != Shape.ShapeTypeID.ZTYPE)) {
                if (array[0] == array[1]) {
                    toRemove.add(array);
                }
            }
            if ((shape.getID() != Shape.ShapeTypeID.JTYPE ) && (shape.getID() != Shape.ShapeTypeID.OTYPE)
                    && (shape.getID() != Shape.ShapeTypeID.STYPE )) {
                if (array[2] == array[1]) {
                    toRemove.add(array);
                }
            }
            if ((shape.getID() != Shape.ShapeTypeID.LTYPE ) && (shape.getID() != Shape.ShapeTypeID.ZTYPE)
                    && (shape.getID() != Shape.ShapeTypeID.TTYPE )) {
                if (array[2] == array[3]) {
                    toRemove.add(array);
                }
            }
        }
        shapes.removeAll(toRemove);
        return shapes;
    }

}
