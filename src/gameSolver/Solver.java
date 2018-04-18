package gameSolver;

import gameboard.logic.board.KenkenBoard;
import gameboard.logic.shapes.Shape;
import jdk.jshell.execution.Util;

import java.util.*;

/**
 * Created by ${gaboq} on 17/4/2018.
 */

public class Solver {

    private HashMap numbers;

    public Solver(int lendth) {
        numbers = new HashMap();
        numbersMap(lendth);

    }

    public Solver(KenkenBoard board) {

    }

    private void numbersMap(int lendth) {
        int indice = 10;
        ArrayList<Integer> numArray = new ArrayList<>();
        for (int i = 0; i < lendth; i++) {
            if (i < 10) {
                numArray.add((i));
            } else {
                numArray.add((i+1) - (indice += 2));
            }
        }
        int index = 10;
        for (int i = 0; i < lendth; i++) {
            ArrayList<Integer> aux = (ArrayList<Integer>) numArray.clone();
            aux.remove(i);
            if (i < 10) {
                numbers.put((i), aux);
            } else {
                numbers.put((i+1) - (index += 2), aux);
            }
        }
    }

    public void dislay() {
        Set set = numbers.entrySet();
        for (Object aSet : set) {
            Map.Entry me = (Map.Entry) aSet;
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
    }

    public ArrayList<Integer> permute(ArrayList<Integer> array) {
        int removed = array.remove(0);
        array.add(-1, removed);
        return array;
    }

    private int[] getColumn(int[][] mat, int column) {
        int[] result = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            result[i] = mat[i][column];
        }
        return result;
    }

    public void solve(Shape[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                Shape aux = mat[i][j];

            }
        }
    }


}