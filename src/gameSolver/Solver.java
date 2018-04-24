package gameSolver;

import gameboard.logic.board.KenkenBoard;
import gameboard.logic.shapes.Shape;

import java.util.*;

/**
 * Created by ${gaboq} on 17/4/2018.
 */

public class Solver {

    private HashMap numbers;
    public Operate permutation;
    KenkenBoard board;

    public Solver(int length) {
        numbers = new HashMap();
        numbersMap(length);
        permutation = new Operate(generateNumbers(length));
    }

    public Solver(KenkenBoard board, int length) {
        this.board = board;
        numbers = new HashMap();
        numbersMap(length);
        permutation = new Operate(generateNumbers(length));
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
                numbers.put((i), aux);
        }
    }

    private ArrayList<Integer> generateNumbers(int length) {
        ArrayList<Integer> numArray = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numArray.add((i));
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

    public ArrayList<int[]> generatePermutations(Shape[][] mat) {
        ArrayList<int[]> permutations = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                Shape shape = mat[i][j];
                if (!shape.visited) {
                    String op = shape.getOperation().getSymbol();
                    int length = shape.getID().getLength();
                    int target = shape.getObjective();

                    switch (length) {
                        case 1:
                            permutations = permutation.permutateOne(target);
                            break;
                        case 2:
                            permutations = permutation.permutateTwo(op, target);
                            break;
                        case 3:
                            permutations = permutation.permutateThree(op, target);
                            break;
                        case 4:
                            permutations = permutation.permutateFour(op, target);
                            break;
                    }
                    shape.permutations = permutations;
                    shape.visited = true;
                }
            }
        }
        return permutations;
    }

    public boolean solve(int row, int column) {
        Shape shape = board.getShapeboard()[row][column];
        ArrayList<int[]> permutations = shape.permutations;
        for (int[] p : permutations) {
            if (complete(row, column)) {
                return true;
            }
            // Podas aqui
            if (validPlace(row, column, board.getBoard())) {
                shape.number = p;
                if (row == board.getNumRows()-1) {
                    return solve(0, column++);
                }
                return solve(row++, column);
            }
        }
        return false;
    }

    private boolean complete(int row, int column) {
        if (row == board.getNumRows()-1 && column == board.getNumRows()-1) {
            return true;
        }
        return false;
    }


}