package board.logic.shapes;

import java.util.ArrayList;

public class Stype extends Shape {

    public Stype(){
        operations = new ArrayList<>();
        orientations = new int[2][3][3];
        int s0[][] = {  {0,1,1},
                        {1,1,0},
                        {0,0,0}};
        orientations[0] = s0;
        int s1[][] = {  {1,0,0},
                        {1,1,0},
                        {0,1,0}};
        orientations[1] = s1;
    }

    @Override
    public void fill(int[][] board, int i, int j, int orientation) {

    }

    @Override
    public boolean fits(int[][] board, int i, int j, int orientation) {
        return false;
    }
}
