package gameboard.logic.shapes;

import java.util.ArrayList;

public class TwoType extends Shape {

    public TwoType(){
        ID = ShapeTypeID.TWOTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }

    @Override
    public String toString() {
        return "2";
    }

}
