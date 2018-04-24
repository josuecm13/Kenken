package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Otype extends Shape {

    public Otype(int range, boolean isRandom){
        this.range = range;
        ID = ShapeTypeID.OTYPE;
        number = new int[ID.getLength()];
        coordinates = new int[ID.getLength()][2];
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        if (isRandom) {
            objective = Generator.generateResult(ID, operation,range);
        }
    }
    @Override
    public String toString() {
        return "O";
    }

}
