package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class TwoType extends Shape {

    public TwoType(int range){
        this.range = range;
        ID = ShapeTypeID.TWOTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);
    }

    @Override
    public String toString() {
        return "2";
    }

}
