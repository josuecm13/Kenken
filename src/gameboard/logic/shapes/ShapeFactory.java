package gameboard.logic.shapes;

import java.util.Random;

public class ShapeFactory {


    public static Shape getInstance(int range) {
        Random rand = new Random();
        int option = rand.nextInt(Shape.getCount());
        switch (option){
            case 0:
                return new Stype(range);
            case 1:
                return new Ztype(range);
            case 2:
                return new Ltype(range);
            case 3:
                return new Otype(range);
            case 4:
                return new Jtype(range);
            case 5:
                return new Itype(range);
            case 6:
                return new Ttype(range);
            case 7:
                return new TwoType(range);
            default:
                return new OneType(range);
        }
    }



}
