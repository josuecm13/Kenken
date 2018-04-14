package board.logic.shapes;

import java.util.ArrayList;

public class Ltype extends Shape {

    public Ltype(){
        operations = new ArrayList<>();
        orientations = new int[4][3][3];
        int[][] l0 = {{1, 0, 0},
                {1, 0, 0},
                {1, 1, 0}};
        orientations[0] = l0;
        int[][] l1 = {{1, 1, 1},
                {1, 0, 0},
                {0, 0, 0}};
        orientations[1] = l1;
        int[][] l2 = {{1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}};
        orientations[2] = l2;
        int[][] l3 = {{0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        orientations[3] = l3;
    }

    @Override
    public void fill(int[][] board, int i, int j, int orientation) {

    }

    @Override
    public boolean fits(int[][] board, int i, int j, int orientation) {
        return false;
    }
}
