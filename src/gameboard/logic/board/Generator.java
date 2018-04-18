package gameboard.logic.board;

import gameboard.logic.shapes.Shape;

import java.util.Random;

public class Generator {

    public static int generateResult(Shape.ShapeTypeID shape, Operation operation, int range){
        switch (operation){
            case ADD:
                break;
        }
        return 0;
    }

    private int[] range(int n){
        int[] list = new int[n];
        for (int i = 0; i < n ; i++) {
            list[i] = i;
        }
        return list;
    }

    private int[] generateRandomArray(int range, int length){
        Random r = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            int element = r.nextInt(range);
            array[i] = element;
        }
        return  array;
    }

    private static boolean valid(int[] array, int[] valid){
        for (int i = 0; i < array.length; i++) {
            if(repeats(array[i], array, i)){
            }
        }
        return true;
    }

    private static boolean repeats(int element, int[] array, int index){
        for (int i = 0; i < array.length ; i++) {
            if(i == index)
                continue;
            if(array[i] == i)
                return true;
        }
        return true;
    }

    private static int sum(Shape.ShapeTypeID shapeTypeID, int[] range){
        Random r = new Random();
        for (int i = 0; i < shapeTypeID.getLength(); i++) {
            int operand = r.nextInt();
        }
        return 0;
    }

}
