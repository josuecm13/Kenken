package gameSolver;

import gameboard.logic.board.KenkenBoard;
import gameboard.logic.shapes.Shape;

import java.util.*;

/**
 * Created by ${gaboq} on 17/4/2018.
 */

public class Solver {

    public Operate permutation;
    KenkenBoard board;
    private int length;

    public Solver(int length) {
        permutation = new Operate(generateNumbers(length));
    }

    public Solver(KenkenBoard board, int length) {
        this.board = board;
        permutation = new Operate(generateNumbers(length));
        this.length = length;
    }

    private ArrayList<Integer> generateNumbers(int length) {
        ArrayList<Integer> numArray = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numArray.add((i));
        }
        return numArray;
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
        setVisitedFalse();
        return permutations;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length ; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean solveAux(int row, int column, int[][] matrix, Shape[][] shapeBoard) {
        printMatrix(matrix.clone());
        if (complete(row, column, matrix)) {
            printMatrix(matrix.clone());
            return true;
        }
        int size = (matrix.length-1);
        Shape shape = shapeBoard[row][column];
        ArrayList<int[]> permutations = shape.permutations;
        for (int[] p : permutations) {
            shape.number = p.clone();
            if (valid(shape.setPermutation(matrix).clone())) {

                matrix = shape.setPermutation(matrix);
                shape.visited = true;
                if (solveAux(column == size ? (row % size) + 1 : (row % size), column == size ? 0 : (column % size) + 1, matrix, shapeBoard))
                    return true;
            }
            shape.number = empty(shape.number);
            matrix = shape.setPermutation(matrix);
        }
        return false;
    }

    private int[] empty(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MIN_VALUE;
        }
        return array.clone();
    }

    private boolean valid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!checkColumn(matrix[i]) || !checkColumn(getColumn(matrix, i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int[] matrix) {
        int cont = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j] >= 0) {
                    if (i == matrix[j]) {
                        cont++;
                    }
                }
                if (cont > 1) {
                    return false;
                }
            }
            cont = 0;
        }
        return true;
    }

    private boolean complete(int row, int column, int[][] matrix) {
        if (row == board.getNumRows() - 1 && column == board.getNumRows() - 1 && valid(matrix)) {
            return true;
        }
        return false;
    }

    public void solve() {
        solvePows();
        solveAux(0, 0, board.getBoard(), board.getShapeboard());
    }

    private void solvePows() {
        for (int i = 0; i < board.getShapeboard().length; i++) {
            for (int j = 0; j < board.getShapeboard()[0].length; j++) {
                Shape shape = board.getShapeboard()[i][j];
                if (shape.getOperation().getSymbol().equals("^")) {
                    shape.number = shape.permutations.get(0);
                    shape.setPermutation(board.getBoard());
                    shape.visited = true;
                }
            }
        }
    }

    private void setVisitedFalse(){
        for (int i = 0; i < board.getShapeboard().length; i++) {
            for (int j = 0; j < board.getShapeboard()[0].length; j++) {
                Shape shape = board.getShapeboard()[i][j];
                shape.visited = false;
            }
        }
    }

}