package gameSolver;

import gameboard.logic.board.KenkenBoard;
import gameboard.logic.shapes.Shape;

import java.util.*;

/**
 * Created by ${gaboq} on 17/4/2018.
 */

public class Solver {

    private HashMap numbers;

    public Solver(int length) {
        numbers = new HashMap();
        numbersMap(length);
    }

    public Solver(KenkenBoard board, int length) {
        numbers = new HashMap();
        numbersMap(length);

    }

    public HashMap getNumbers() {
        return numbers;
    }

    private void numbersMap(int length) {
        ArrayList<Integer> numArray = generateNumbers(length);
        int index = 10;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> aux = (ArrayList<Integer>) numArray.clone();
            aux.remove(i);
            if (i < 10) {
                numbers.put((i), aux);
            } else {
                numbers.put((i) - (index += 1), aux);
            }
        }
    }

    private ArrayList<Integer> generateNumbers(int length) {
        int indice = 10;
        ArrayList<Integer> numArray = new ArrayList<>();
        for (int i = 1; i < length+1; i++) {
            if (i < 10) {
                numArray.add((i));
            } else {
                numArray.add((i) - (indice));
                indice += 2;
            }
        }
        return numArray;
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

    private boolean contains(int num, int[] line) {
        List<int[]> list = Arrays.asList(line);
        if (list.contains(num)) {
            return true;
        }
        return false;
    }

    private boolean validPlace(int row, int col, int[][] mat) {
        int[] column = getColumn(mat, col);
        int[] rows = mat[row];
        if (!contains(mat[row][col], column) && !contains(mat[row][col], rows)) {
            return true;
        }
        return false;
    }

    public void solve(Shape[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                Shape aux = mat[i][j];
                String op = aux.getOperation().getSymbol();
                int length = aux.getID().getLength();
                int target = aux.getObjective();
                if (op.equals("^")) {
                    Exponent e = new Exponent(numbers);
                    e.exp(target);
                    continue;
                }

                switch (op) {
                    case "+":
                        Addition a = new Addition(numbers);
                        a.sum(target, 3);
                        break;
                    case  "-":
                        Subtraction s = new Subtraction(numbers);
                        s.sub(target, 4);
                        break;
                    case "x":
                        Multiplication mu = new Multiplication(numbers);
                        mu.mul(target, 2);
                        break;
                    case "÷":

                        break;
                    case  "%":
                        Module m = new Module(numbers);
                        m.mod(target);
                        break;
                }

                Operate operat;

            }
        }
    }


}