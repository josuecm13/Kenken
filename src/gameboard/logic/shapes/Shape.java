package gameboard.logic.shapes;


import gameboard.logic.board.Operation;

import java.util.List;
import java.util.Random;

public abstract class Shape {
    public enum ShapeTypeID {LTYPE,JTYPE,OTYPE,ITYPE,TTYPE,STYPE,ZTYPE,TWOTYPE,ONETYPE}
    public int[][][] orientations;
    public List<Operation> operations;
    public int LENGHT;
    public int[] number;
    public int[] head = new int[2];
    protected Operation operation;
    protected int objective;
    protected ShapeTypeID ID;

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

    public void placeShape(Shape shapeBoard[][],int i, int j){
        Random rand = new Random();
        int orientation = rand.nextInt(orientations.length);
        while (!fits(shapeBoard, i, j, orientation)){
            orientation = rand.nextInt(orientations.length);
        }
        fill(shapeBoard, i, j, orientation);
    }

    private void fill(Shape[][] shapeBoard, int i, int j, int orientation){
        int firstItem = -1;
        head[0] = i;
        head[1] = j;
        for (int k = 0; k < orientations[orientation][0].length; k++) {
            if(orientations[orientation][0][k] == 1) {
                firstItem = k;
                break;
            }
        }
        for(int n = 0; n < orientations[orientation].length; n++){
            for (int m = 0; m < orientations[orientation][0].length; m++) {
                if(orientations[orientation][n][m] == 1) {
                    shapeBoard[i+n][j+m-firstItem] = this;
                }
            }
        }
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

    public boolean isHead(int i , int j){
        return (head[0] == i && head[1] == j);
    }

    public int getObjective(){
        Random r = new Random();
        return (objective== 0 ? r.nextInt(30) : objective);
    }

    public String getOperation(){
        Random r = new Random();
        String[] ops = {"+","-","x","/","%"};
        return ops[r.nextInt(ops.length)];
    }

    public abstract String toString();


}
