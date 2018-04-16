package gameboard.logic.shapes;

import java.util.ArrayList;

public class Jtype extends Shape {

    public Jtype(){
        operations = new ArrayList<>();
        orientations = new int[4][3][3];
        ID = ShapeTypeID.JTYPE;
        int[][] j0 = new int[][]{{0, 1, 0},
                {0, 1, 0},
                {1, 1, 0}};
        orientations[0] = j0;
        int[][] j1 = {{1, 0, 0},
                {1, 1, 1},
                {0, 0, 0}};
        orientations[1] = j1;
        int[][] j2 = {{1, 1, 0},
                {1, 0, 0},
                {1, 0, 0}};
        orientations[2] = j2;
        int[][] j3 = {{1, 1, 1},
                {0, 0, 1},
                {0, 0, 0}};
        orientations[3] = j3;
    }


    @Override
    public String toString() {
        return "J";
    }
}
