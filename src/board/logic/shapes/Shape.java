package board.logic.shapes;


import board.logic.board.Operation;

import java.util.List;

public abstract class Shape {
    public enum ShapeTypeID {LTYPE,JTYPE,OTYPE,ITYPE,TTYPE,STYPE,ZTYPE,TWOTYPE,ONETYPE}
    public int[][][] orientations;
    public List<Operation> operations;
    public int[] number;
    protected Operation operation;
    protected int result;
    protected ShapeTypeID ID;

    public boolean fits(int[][] board, int i, int j){
        for (int k = 0; k < orientations.length ; k++) {
            if (fits(board, i, j,k))
                return true;
        }
        return false;
    }
    public void fill(int[][] board, int i, int j, int orientation){
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
                    board[i+n][j+m-firstItem] = ID.ordinal();
                }
            }
        }
    }

    public boolean fits(int[][] board, int i,int j, int orientation){
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
                        if (board[i + n][j + m - firstItem] != -1) {
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

}
