package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Itype extends Shape {

    public Itype(int range){
        this.range = range;
        ID = ShapeTypeID.ITYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);
    }


    @Override
    public String toString() {
        return "I";
    }
}
