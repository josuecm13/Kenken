package gameboard.logic.shapes;

import java.util.ArrayList;

public class Stype extends Shape {

    public Stype(){
        LENGHT = 4;
        operations = new ArrayList<>();
        orientations = new int[2][3][3];
        ID = ShapeTypeID.STYPE;
        int s0[][] = {  {0,1,1},
                        {1,1,0},
                        {0,0,0}};
        orientations[0] = s0;
        int s1[][] = {  {1,0,0},
                        {1,1,0},
                        {0,1,0}};
        orientations[1] = s1;
    }

    @Override
    public String toString() {
        return "S";
    }

}
