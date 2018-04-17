package gameboard.logic.shapes;

import java.util.ArrayList;

public class Stype extends Shape {

    public Stype(){
        ID = ShapeTypeID.STYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }

    @Override
    public String toString() {
        return "S";
    }

}
