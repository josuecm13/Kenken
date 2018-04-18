package gameboard.logic.board;

import gameboard.logic.shapes.Shape;

import java.util.Random;

public class Generator {

    public static int generateResult(Shape.ShapeTypeID shape, Operation operation, int range){
        int[] array = generateRandomArray(range,shape.getLength());
        while (!isValid(array, shape.getValid_combination()))
            array = generateRandomArray(range,shape.getLength());
        switch (operation){
            case ADD:
                return sum(array);
            case SUB:
                return sub(array);
            case MUL:
                return mul(array);
            case EXP:
                return exp(array);
            case MOD:
                return mod(array);
            default:
                return div(array);
        }
    }

    private static int sum(int[] array){
        int result = 0;
        for (int i: array){
            result += i;
        }
        return result;
    }

    private static int exp(int[] array) {
        return (int) Math.pow(2,array[0]);
    }

    private static int mul(int[] array) {
        int result = 0;
        for (int i: array){
            result *= i;
        }
        return result;
    }

    private static int sub(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result -= array[i];
        }
        return result;
    }

    private static int mod(int[] array){
        return array[1] == 0 ? array[0] % 3:array[0] % array[1] ;
    }

    private static int div(int[] array){
        return array[1] == 0 ? array[0] / 3:array[0] / array[1] ;
    }

    private static int[] range(int n){
        int[] list = new int[n];
        for (int i = 0; i < n ; i++) {
            list[i] = i;
        }
        return list;
    }

    private static int[] generateRandomArray(int range, int length){
        Random r = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            int element = r.nextInt(range);
            array[i] = element;
        }
        return  array;
    }

    private static boolean isValid(int[] array, int[][] valid){
        for (int i = 0; i < array.length; i++) {
            if(repeats(array[i], array, i)){
                if(! in(i,repetition(array[i],array,i),valid))
                    return false;
            }
        }
        return true;
    }

    private static boolean in(int indexA,int indexB, int[][] valid){
        boolean isValid = false;
        for (int[] e: valid) {
            if ((e[0] == indexA || e[0] == indexB) && (e[1] == indexA || e[1] == indexB))
                return true;
        }
        return false;
    }

    private static int repetition(int element, int[] array, int index){
        for (int i = 0; i < array.length ; i++) {
            if(i == index)
                continue;
            if(array[i] == element)
                return i;
        }
        return -1;
    }

    private static boolean repeats(int element, int[] array, int index){
        for (int i = 0; i < array.length ; i++) {
            if(i == index)
                continue;
            if(array[i] == element)
                return true;
        }
        return false;
    }


}
