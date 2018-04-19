package gameboard.logic.shapes;

import gameboard.logic.board.Generator;

import java.util.Random;

public class OneType extends Shape {

    public OneType(int range){
        this.range = range;
        ID = ShapeTypeID.ONETYPE;
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
        Random r = new Random();
        return (int) Math.pow(2,r.nextInt(5));
    }

}
