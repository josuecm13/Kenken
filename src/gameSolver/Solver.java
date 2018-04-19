package gameSolver;

import gameSolver.Operations.Sum;
import gameboard.logic.board.KenkenBoard;
import gameboard.logic.shapes.Shape;

import java.util.*;

/**
 * Created by ${gaboq} on 17/4/2018.
 */

public class Solver {

    private HashMap numbers;
    private Sum add;

    public Solver(int length) {
        numbers = new HashMap();
        numbersMap(length);
        add = new Sum(numbers);
    }

    public Solver(KenkenBoard board, int length) {
        numbers = new HashMap();
        numbersMap(length);

    }

    public HashMap getNumbers() {
        return numbers;
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
        String str;
        for (int i = 0; i < mat.length; i++) {
            str = "";
            for (int j = 0; j < mat[0].length; j++) {

                Shape aux = mat[i][j];
                String op = aux.getID().getOperation().getSymbol();
                int length = aux.getID().getLength();
                int target = aux.getObjective();

                //str += (aux.getID().toString() + op + "   ");
                str += (aux.getClass().toString() +  "    ");

                switch (op) {
                    case "+":
                        add.sum(target, length);
                        break;
                    case  "-":
                        break;
                    case "x":
                        break;
                    case "÷":
                        break;
                    case "^":
                        break;
                    case  "%":
                        break;

                }

            }
            System.out.println(str);
        }
        System.out.println();
    }


}