package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Ltype extends Shape {

    public Ltype(int range){
        this.range = range;
        ID = ShapeTypeID.LTYPE;
        number = new int[ID.getLength()];
        coordinates = new int[ID.getLength()][2];
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);

    }

    @Override
    public String toString() {
        return "L";
    }

}
