package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class Jtype extends Shape {

    public Jtype(int range, boolean isRandom){
        this.range = range;
        ID = ShapeTypeID.JTYPE;
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
        return "J";
    }
}
