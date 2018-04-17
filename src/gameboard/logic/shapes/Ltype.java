package gameboard.logic.shapes;

import java.util.ArrayList;

public class Ltype extends Shape {

    public Ltype(){
        ID = ShapeTypeID.LTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }

    @Override
    public String toString() {
        return "L";
    }

}
