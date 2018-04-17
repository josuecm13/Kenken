package gameboard.logic.shapes;

import java.util.ArrayList;
import java.util.Random;

public class OneType extends Shape {

    public OneType(){
        ID = ShapeTypeID.ONETYPE;
        orientations = ID.getOrientations();
        operation = ID.getOperation();
    }

    @Override
    public String toString() {
        return "1";
    }

    @Override
    public String getOperation(){
        return "^";
    }

    @Override
    public int getObjective(){
        Random r = new Random();
        return (int) Math.pow(2,r.nextInt(5));
    }

}
