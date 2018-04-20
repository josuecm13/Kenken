package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Ztype extends Shape {

    public Ztype(int range){
        this.range = range;
        ID = ShapeTypeID.ZTYPE;
        number = new int[ID.getLength()];
        coordinates = new int[ID.getLength()][2];
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);
    }

    @Override
    public String toString() {
        return "Z";
    }

}
