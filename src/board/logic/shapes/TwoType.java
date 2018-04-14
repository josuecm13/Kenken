package board.logic.shapes;

import java.util.ArrayList;

public class TwoType extends Shape {

    public TwoType(){
        operations = new ArrayList<>();
        orientations = new int[2][2][2];
        int vert[][] = {{1,0},
                        {1,0}};
        orientations[0] = vert;
        int hor[][] =  {{1,1},
                        {0,0}};
        orientations[1] = hor;
    }

    @Override
    public void fill(int[][] board, int i, int j, int orientation) {

    }

    @Override
    public boolean fits(int[][] board, int i, int j, int orientation) {
        return false;
    }
}
