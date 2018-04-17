package gameboard.logic.shapes;

import java.util.ArrayList;

public class Itype extends Shape {

    public Itype(){
        ID = ShapeTypeID.ITYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }


    @Override
    public String toString() {
        return "I";
    }
}
