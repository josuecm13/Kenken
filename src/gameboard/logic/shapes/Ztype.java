package gameboard.logic.shapes;

import java.util.ArrayList;

public class Ztype extends Shape {

    public Ztype(){
        ID = ShapeTypeID.ZTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }

    @Override
    public String toString() {
        return "Z";
    }

}
