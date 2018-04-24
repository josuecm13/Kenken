package gameboard.logic.shapes;

import java.util.Random;

public class ShapeFactory {


    public static Shape getInstance(int range, boolean isRandom) {
        Random rand = new Random();
        int option = rand.nextInt(Shape.getCount());
        switch (option){
            case 0:
                return new Stype(range, isRandom);
            case 1:
                return new Ztype(range, isRandom);
            case 2:
                return new Ltype(range, isRandom);
            case 3:
                return new Otype(range, isRandom);
            case 4:
                return new Jtype(range, isRandom);
            case 5:
                return new Itype(range, isRandom);
            case 6:
                return new Ttype(range, isRandom);
            case 7:
                return new TwoType(range, isRandom);
            default:
                return new OneType(range, isRandom);
        }
    }



}
