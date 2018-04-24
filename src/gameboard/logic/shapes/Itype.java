package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Itype extends Shape {

    public Itype(int range, boolean isRandom){
        this.range = range;
        ID = ShapeTypeID.ITYPE;
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
        return "I";
    }
}
