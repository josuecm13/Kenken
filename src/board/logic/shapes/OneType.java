package board.logic.shapes;

import java.util.ArrayList;

public class OneType extends Shape {

    public OneType(){
        operations = new ArrayList<>();
        orientations = new int[1][1][1];
    }

    @Override
    public void fill(int[][] board, int i, int j, int orientation) {

    }

    @Override
    public boolean fits(int[][] board, int i, int j, int orientation) {
        return false;
    }
}
