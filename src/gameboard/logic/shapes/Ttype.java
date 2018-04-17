package gameboard.logic.shapes;

import java.util.ArrayList;

public class Ttype extends Shape {


    public Ttype(){
        ID = ShapeTypeID.TTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }


    @Override
    public String toString() {
        return "T";
    }


}
