package gameboard.logic.shapes;

import java.util.ArrayList;

public class Otype extends Shape {

    public Otype(){
        operations = new ArrayList<>();
        orientations = new int[1][2][2];
        ID = ShapeTypeID.OTYPE;
        int o[][] = {   {1,1},
                        {1,1}};
        orientations[0] = o;
    }

    @Override
    public String toString() {
        return "O";
    }

}
