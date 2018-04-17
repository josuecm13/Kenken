package gameboard.logic.shapes;

import java.util.ArrayList;

public class Otype extends Shape {

    public Otype(){
        ID = ShapeTypeID.OTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }

    @Override
    public String toString() {
        return "O";
    }

}
