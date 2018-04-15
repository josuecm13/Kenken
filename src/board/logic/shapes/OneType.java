package board.logic.shapes;

import java.util.ArrayList;

public class OneType extends Shape {

    public OneType(){
        operations = new ArrayList<>();
        orientations = new int[][][]{{{1}}};
        ID = ShapeTypeID.ONETYPE;
    }

}
