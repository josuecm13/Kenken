package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Stype extends Shape {

    public Stype(int range){
        this.range = range;
        ID = ShapeTypeID.STYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);
    }

    @Override
    public String toString() {
        return "S";
    }

}
