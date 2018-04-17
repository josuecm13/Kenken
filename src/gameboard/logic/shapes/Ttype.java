package gameboard.logic.shapes;

import java.util.ArrayList;

public class Ttype extends Shape {


    public Ttype(){
        LENGHT = 4;
        operations = new ArrayList<>();
        orientations = new int[4][3][3];
        ID = ShapeTypeID.TTYPE;
        int t0[][] = {  {1,1,1},
                        {0,1,0},
                        {0,0,0}};
        orientations[0]  = t0;
        int t1[][] = {  {0,1,0},
                        {1,1,0},
                        {0,1,0}};
        orientations[1] = t1;
        int t2[][] = {  {0,1,0},
                        {1,1,1},
                        {0,0,0}};
        orientations[2] = t2;
        int t3[][] = {  {1,0,0},
                        {1,1,0},
                        {1,0,0}};
        orientations[3] = t3;
    }


    @Override
    public String toString() {
        return "T";
    }


}
