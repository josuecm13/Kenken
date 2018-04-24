package gameboard.logic.shapes;


import gameboard.logic.board.Generator;
import gameboard.logic.board.Operation;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shape {
    public int[][][] orientations;
    public int[] number;
    int[][] coordinates;
    private int[] head = new int[2];
    protected Operation operation;
    protected int objective;
    protected ShapeTypeID ID;
    int range;

    public ArrayList<int[]> permutations;
    public boolean visited = false;

    public boolean fits(Shape[][] board, int i, int j){
        for (int k = 0; k < orientations.length ; k++) {
            if (fits(board, i, j,k))
                return true;
        }
        return false;
    }


    public static int getCount(){
        return 9;
    }

    public void placeShape(Shape shapeBoard[][], int[][] matrix, int i, int j, boolean solvable){
        Random rand = new Random();
        int orientation = rand.nextInt(orientations.length);
        while (!fits(shapeBoard, i, j, orientation)){
            orientation = rand.nextInt(orientations.length);
        }
        fill(shapeBoard, i, j, orientation, matrix, solvable);
    }




    private void fill(Shape[][] shapeBoard, int i, int j, int orientation, int[][] matrix, boolean solvable){
        int firstItem = -1;
        int[] solution = new int[ID.getLength()];
        head[0] = i;
        head[1] = j;
        for (int k = 0; k < orientations[orientation][0].length; k++) {
            if(orientations[orientation][0][k] == 1) {
                firstItem = k;
                break;
            }
        }
        int cont = 0;
        for(int n = 0; n < orientations[orientation].length; n++){
            for (int m = 0; m < orientations[orientation][0].length; m++) {
                if(orientations[orientation][n][m] == 1) {
                    solution[cont] = matrix[i+n][j+m-firstItem];
                    coordinates[cont++]= new int[]{i+n,j+m-firstItem};
                    shapeBoard[i+n][j+m-firstItem] = this;
                }
            }
        }
        if(solvable)
            setObjective(solution);
    }


    private boolean fits(Shape[][] shapeBoard, int i, int j, int orientation){
        if(i == j && i == 0 && orientations[orientation][0][0] == 0){
            return false;
        }
        int firstItem = -1;
        for (int k = 0; k < orientations[orientation][0].length; k++) {
            if(orientations[orientation][0][k] == 1) {
                firstItem = k;
                break;
            }
        }
        for(int n = 0; n < orientations[orientation].length; n++){
            for (int m = 0; m < orientations[orientation][0].length; m++) {
                if(orientations[orientation][n][m] == 1) {
                    try {
                        if (shapeBoard[i + n][j + m - firstItem] != null) {
                            return false;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void setObjective(int[] numbers){
        objective = Generator.operate(operation,numbers);
    }

    public boolean isHead(int i , int j){
        return (head[0] == i && head[1] == j);
    }

    public int getObjective(){
        return objective;
    }

    public Operation getOperation(){
        return operation;
    }

    public ShapeTypeID getID() {
        return ID;
    }

    public abstract String toString();


    public enum ShapeTypeID {
        LTYPE(  new int[][][]{{{1, 0, 0}, {1, 0, 0}, {1, 1, 0}},
                {{1, 1, 1}, {1, 0, 0}, {0, 0, 0}},
                {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}},
                {{0, 0, 1}, {1, 1, 1}, {0, 0, 0}}},
                4, new int[][]{{0,3},{0,2}},new Operation[]{Operation.ADD,Operation.SUB,Operation.MUL}),

        JTYPE(   new int[][][]{{{0, 1, 0}, {0, 1, 0}, {1, 1, 0}},
                {{1, 0, 0}, {1, 1, 1}, {0, 0, 0}},
                {{1, 1, 0}, {1, 0, 0}, {1, 0, 0}},
                {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}}},
                4, new int[][]{{0, 3}, {1, 3}},new Operation[]{Operation.ADD,Operation.SUB,Operation.MUL}),

        OTYPE(  new int[][][]{{{1, 1}, {1, 1}}},
                4,new int[][] {{0, 3}, {1, 2}},new Operation[]{Operation.ADD,Operation.SUB,Operation.MUL}),

        ITYPE(  new int[][][]{{{1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}},
                {{1, 1, 1, 1},{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}},
                4,new int[0][0],new Operation[]{Operation.ADD,Operation.SUB,Operation.MUL}),

        TTYPE(  new int[][][]{{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}},
                {{0, 1, 0}, {1, 1, 0}, {0, 1, 0}},
                {{0, 1, 0}, {1, 1, 1}, {0, 0, 0}},
                {{1, 0, 0}, {1, 1, 0}, {1, 0, 0}}},
                4,new int[][]{},new Operation[]{Operation.ADD,Operation.MUL}),

        STYPE(  new int[][][]{{ {0, 1, 1}, {1, 1, 0}, {0, 0, 0}},
                                {{1, 0, 0},{1, 1, 0}, {0, 1, 0}}},
                4, new int[][]{{0,2}, {0,3}, {1,3}},new Operation[]{Operation.ADD,Operation.SUB,Operation.MUL}),

        ZTYPE(  new int[][][]{{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}},
                {{0, 1, 0}, {1, 1, 0}, {1, 0, 0}}},
                4, new int[][]{{0, 2}, {0, 3}, {1, 3}},new Operation[]{Operation.ADD,Operation.SUB,Operation.MUL}),

        TWOTYPE(new int[][][]{{{1, 0}, {1, 0}},
                {{1, 1}, {0, 0}}},
                2, new int[0][0],new Operation[]{Operation.DIV,Operation.ADD,Operation.MUL,Operation.MOD,Operation.SUB}),

        ONETYPE(    new int[][][]{{{1}}},
                1, new int[0][0],new Operation[]{Operation.EXP});

        private final int[][][] orientations;
        private final int length;
        private final int[][] valid_combination;
        private final Operation[] op;

        ShapeTypeID(int[][][] orientations, int length, int[][] valid_combination, Operation[] operations) {
            this.orientations = orientations;
            this.length = length;
            this.valid_combination = valid_combination;
            this.op = operations;
        }

        public int getLength() {
            return length;
        }

        public int[][][] getOrientations() {
            return orientations;
        }

        public int[][] getValid_combination() {
            return valid_combination;
        }

        public Operation getOperation(){
            Random r = new Random();
            return op[r.nextInt(op.length)];
        }

    }
}
