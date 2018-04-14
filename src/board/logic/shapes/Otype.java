package board.logic.shapes;

import java.util.ArrayList;

public class Otype extends Shape {

    public Otype(){
        operations = new ArrayList<>();
        orientations = new int[1][2][2];
        int o[][] = {   {1,1},
                        {1,1}};
        orientations[0] = o;
    }

    @Override
    public void fill(int[][] board, int i, int j, int orientation) {

    }

    @Override
    public boolean fits(int[][] board, int i, int j, int orientation) {
        return false;
    }
}
