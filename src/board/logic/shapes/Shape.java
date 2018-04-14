package board.logic.shapes;


import board.logic.board.Operation;

import java.util.List;

public abstract class Shape {

    public int[][][] orientations;
    public List<Operation> operations;
    public int[] number;
    protected Operation operation;
    protected int result;


    public abstract void fill(int[][] board, int i, int j, int orientation);
    public abstract boolean fits(int[][] board, int i,int j, int orientation);

}
