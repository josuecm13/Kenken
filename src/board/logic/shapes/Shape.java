package board.logic.shapes;


import java.util.ArrayList;

public abstract class Shape {

    public ArrayList<int[][]> orientations;
    public ArrayList<Operation> operations;
    protected Operation operation;

    public abstract void fill(int[][] board, int i, int j, int orientation);
    public abstract boolean fits(int[][] board, int i,int j, int orientation);

}
