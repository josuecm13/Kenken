package gameSolver.Operations;

import gameSolver.Solver;
import gameboard.logic.board.KenkenBoard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${gaboq} on 18/4/2018.
 */

public class Sum {

    HashMap numbers;
    int[] numArray;

    public Sum(HashMap nums) {
        this.numbers = nums;
        Object[] p = numbers.keySet().toArray();
        //numArray = (int[]) p;
    }

    public ArrayList<Integer> sum(int target, int len) {
        if (numbers.size() < 11) {
            switch (len) {
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

        } else {
            // Si hay negativos
        }
        return null;
    }

}
