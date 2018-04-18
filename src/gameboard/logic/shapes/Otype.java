package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Otype extends Shape {

    public Otype(int range){
        this.range = range;
        ID = ShapeTypeID.OTYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);
    }

    @Override
    public String toString() {
        return "O";
    }

}
