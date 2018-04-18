package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Jtype extends Shape {

    public Jtype(int range){
        this.range = range;
        ID = ShapeTypeID.JTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);
    }


    @Override
    public String toString() {
        return "J";
    }
}
