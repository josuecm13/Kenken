package gameSolver;

import gameboard.logic.board.KenkenBoard;
import gameboard.logic.shapes.Shape;

import java.util.*;

/**
 * Created by ${gaboq} on 17/4/2018.
 */

public class Solver {

    private Operate permutation;
    private KenkenBoard kenkenBoard;
    private int shapeNum;
    private int board[][];
    private Shape shapeboard[][];

    public Solver(KenkenBoard board, int length) {
        this.kenkenBoard = board;
        this.board = kenkenBoard.getBoard();
        this.shapeboard = kenkenBoard.getShapeboard();
        permutation = new Operate(generateNumbers(length));
        shapeNum = countShapes(board.getShapeboard());
    }

    public int[][] getBoard() {
        return board;
    }

    public Shape[][] getShapeboard() {
        return shapeboard;
    }

    private ArrayList<Integer> generateNumbers(int length) {
        ArrayList<Integer> numArray = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numArray.add((i));
        }
        return numArray;
    }

    private int countShapes(Shape[][] shape) {
        int result = 0;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (!shape[i][j].visited) {
                    result++;
                    shape[i][j].visited = true;
                }
            }
        }
        setVisitedFalse(shape);
        return result;
    }

    private int[] getColumn(int[][] mat, int column) {
        int[] result = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            result[i] = mat[i][column];
        }
        return result;
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
        setVisitedFalse(mat);
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

    private boolean solveAux(int row, int column, int[][] matrix, Shape[][] shapeBoard, int counter) {
        printMatrix(matrix.clone());
        if (complete(counter, matrix.clone())) {
            System.out.println("########  Resultado  ########");
            printMatrix(matrix.clone());
            return true;
        }
        int size = (matrix.length-1);
        Shape shape = shapeBoard[row][column];
        if (!(matrix[row][column] == Integer.MIN_VALUE)) {
            return solveAux(column == size ? (row % size) + 1 : (row % size), column == size ? 0 : (column % size) + 1, matrix, shapeBoard, counter);
        }
        ArrayList<int[]> permutations = shape.permutations;
        for (int[] p : permutations) {
            shape.number = p.clone();
            if (valid(shape.setPermutation(matrix).clone())) {
                matrix = shape.setPermutation(matrix);
                if (solveAux(column == size ? (row % size) + 1 : (row % size), column == size ? 0 : (column % size) + 1, matrix, shapeBoard, counter+1))
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

    private boolean complete(int cont, int[][] matrix) {
        if (cont == shapeNum && valid(matrix)) {
            return true;
        }
        return false;
    }

    public void solve() {
        int pows = solvePows();
        System.out.println(solveAux(0, 0, board, shapeboard, pows));
    }

    private int solvePows() {
        int counter = 0;
        for (int i = 0; i < kenkenBoard.getShapeboard().length; i++) {
            for (int j = 0; j < kenkenBoard.getShapeboard()[0].length; j++) {
                Shape shape = kenkenBoard.getShapeboard()[i][j];
                if (shape.getOperation().getSymbol().equals("^")) {
                    shape.number = shape.permutations.get(0);
                    shape.setPermutation(kenkenBoard.getBoard());
                    counter++;
                    shape.visited = true;
                }
            }
        }
        return counter;
    }

    private void setVisitedFalse(Shape[][] shapes){
        for (int i = 0; i < shapes.length; i++) {
            for (int j = 0; j < shapes[0].length; j++) {
                Shape shape = shapes[i][j];
                shape.visited = false;
            }
        }
    }

}