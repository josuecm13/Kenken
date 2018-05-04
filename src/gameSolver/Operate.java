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

    public ArrayList<int[]> permut(int size, int target, String operation, Shape shape) {
        ArrayList<int[]> nums = new ArrayList<>();
        int[] num = new int[size];
        rep(nums, numArray, num, 0, target, operation);
        if (size == 4) {
            shapePodeFour(shape, nums);
        }
        return nums;
    }

    private void rep(ArrayList<int[]> reps, ArrayList<Integer> input, int[] item, int count, int target, String operation) {
        if (count < item.length){
            for (int i = 0; i < input.size(); i++) {
                item[count] = input.get(i);
                rep(reps, input, item, count+1, target, operation);
            }
        }else{
            switch (item.length) {
                case 2:
                    if (operateTwo(target ,operation,item)) {
                        reps.add(item.clone());
                    }
                    break;
                case 4:
                    if (operateFour(target ,operation,item)) {
                        reps.add(item.clone());
                    }
                    break;
            }
        }
    }

    private boolean operateTwo(int target, String operation, int[] array) {
        if (array[0] == array[1]) {
            return false;
        }
        switch (operation) {
            case "+":
                if ((array[0] + array[1]) == target) {
                    return true;
                }
                break;
            case  "-":
                if ((array[0] - array[1]) == target) {
                    return true;
                }
                break;
            case "x":
                if ((array[0] * array[1]) == target) {
                    return true;
                }
                break;
            case "÷":
                if (!(array[1] == 0)) {
                    if ((array[0] / array[1]) == target) {
                        return true;
                    }
                }
                break;
            case  "%":
                if (!(array[1] == 0)) {
                    if ((array[0] % array[1]) == target) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    private boolean operateFour(int target, String operation, int[] array) {
        switch (operation) {
            case "+":
                if ((array[0] + array[1] + array[2] + array[3]) == target) {
                    return true;
                }
                break;
            case  "-":
                if ((array[0] - array[1] - array[2] - array[3]) == target) {
                    return true;
                }
                break;
            case "x":
                if ((array[0] * array[1] * array[2] * array[3]) == target) {
                    return true;
                }
                break;
        }
        return false;
    }

    public ArrayList<int[]> shapePodeFour(Shape shape, ArrayList<int[]> shapes) {
        List<int[]> toRemove = new ArrayList();
        for (int[] array : shapes) {
            if ((shape.getID() != Shape.ShapeTypeID.TTYPE ) && (shape.getID() != Shape.ShapeTypeID.ZTYPE)
                    && (shape.getID() != Shape.ShapeTypeID.LTYPE)) {
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
            if ((shape.getID() == Shape.ShapeTypeID.ITYPE ) || (shape.getID() == Shape.ShapeTypeID.OTYPE)) {
                if (array[2] == array[0] || array[1] == array[3]) {
                    toRemove.add(array);
                }
            }
        }
        shapes.removeAll(toRemove);
        return shapes;
    }

}
