package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Otype extends Shape {

    public Otype(int range){
        this.range = range;
        this.solved = true;
        ID = ShapeTypeID.OTYPE;
        number = new int[ID.getLength()];
        coordinates = new int[ID.getLength()][2];
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);
    }

    @Override
    public String toString() {
        return "O";
    }

}
