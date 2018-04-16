package gameboard.logic.shapes;

import java.util.Random;

public class ShapeFactory {


    public static Shape getInstance() {
        Random rand = new Random();
        int option = rand.nextInt(Shape.getCount());
        switch (option){
            case 0:
                return new Stype();
            case 1:
                return new Ztype();
            case 2:
                return new Ltype();
            case 3:
                return new Otype();
            case 4:
                return new Jtype();
            case 5:
                return new Itype();
            case 6:
                return new Ttype();
            case 7:
                return new TwoType();
            default:
                return new OneType();
        }
    }



}
