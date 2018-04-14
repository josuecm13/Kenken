package board.logic.shapes;

import java.util.ArrayList;

public class Itype extends Shape {

    public Itype(){
        operations = new ArrayList<>();
        orientations = new int[2][4][4];
        int vert[][] = {{1,0,0,0},
                        {1,0,0,0},
                        {1,0,0,0},
                        {1,0,0,0}};
        orientations[0] = vert;
        int hor[][] = { {1,1,1,1},
                        {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0}};
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
