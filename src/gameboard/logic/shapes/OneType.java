package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

public class OneType extends Shape {

    public OneType(int range){
        this.range = range;
        ID = ShapeTypeID.ONETYPE;
        number = new int[ID.getLength()];
        coordinates = new int[ID.getLength()][2];
        orientations = ID.getOrientations();
        operation = ID.getOperation();
        objective = Generator.generateResult(ID, operation,range);

    }

    @Override
    public String toString() {
        return "1";
    }

    @Override
    public int getObjective(){
        return objective;
    }

}
