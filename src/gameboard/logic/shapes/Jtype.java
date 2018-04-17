package gameboard.logic.shapes;

import java.util.ArrayList;

public class Jtype extends Shape {

    public Jtype(){
        ID = ShapeTypeID.JTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }


    @Override
    public String toString() {
        return "J";
    }
}
