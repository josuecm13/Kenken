package gameboard.logic.shapes;

import java.util.ArrayList;

public class Ztype extends Shape {

    public Ztype(){
        operations = new ArrayList<>();
        orientations = new int[1][1][1];
        orientations = new int[2][3][3];
        ID = ShapeTypeID.ZTYPE;
        int s0[][] = {  {1,1,0},
                        {0,1,1},
                        {0,0,0}};
        orientations[0] = s0;
        int s1[][] = {  {0,1,0},
                        {1,1,0},
                        {1,0,0}};
        orientations[1] = s1;
    }

    @Override
    public String toString() {
        return "Z";
    }

}
