package gameboard.logic.board;

import gameboard.logic.shapes.Shape;

import java.util.Random;

public class Generator {

    public static int generateResult(Shape.ShapeTypeID shape, Operation operation, int range){
        int[] array = generateRandomArray(range,shape.getLength(),operation);
        int attempts = 1000;
        while (!isValid(array, shape.getValid_combination()) && attempts-- > 0)
            array = generateRandomArray(range,shape.getLength(),operation);
        return operate(operation,array);
    }

    public static int operate(Operation operation, int[] array){
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

    public static int calculateNumFontSize(int x) {return (int) (160*(Math.pow(0.87055056,x))); }

    public static int calculateFontSize(int x){
        return (int) (-0.64*x +21.09) > 0 ? (int) (-0.64*x +21.09) : 1 ;
    }

    private static int sum(int[] array){
        int result = 0;
        for (int i: array){
            result += i;
        }
        return result;
    }

    private static int exp(int[] array) {
        return (int) Math.pow(array[0],3);
    }

    static int mul(int[] array) {
        int result = 1;
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
        return array[1] == 0 ? array[0] / (array[0]+2) :array[0] / array[1] ;
    }


    private static int[] generateRandomArray(int range, int length, Operation operation){
        Random r = new Random();
        int[] array = new int[length];
        int[] possibilities = range(range);
        for (int i = 0; i < length; i++) {
            int element = r.nextInt(range);
            element = possibilities[element];
            while (operation == Operation.MUL && element == 0) {
                element = r.nextInt(range);
                element = possibilities[element];
            }
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

    public static int[] range(int n){
        int[] possibilities = new int[n];
        for (int i = 0; i < n; i++) {
            possibilities[i] = i;
        }
        return possibilities;
    }


    public static int[][] generateMatrix(int[][] matrix){
        int[] row  = range(matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = row[(j+i) % (matrix.length)];
            }
        }
        Random r = new Random();
        for (int i = 0; i < matrix.length; i++) {
            if(r.nextInt(2) == 1)
                matrix = swapRows(matrix, r.nextInt(matrix[0].length), r.nextInt(matrix[0].length));
            else
                matrix = swapColumns(matrix, r.nextInt(matrix.length), r.nextInt(matrix.length));
        }
        return matrix;
    }

    private static int[][] swapRows(int[][] matrix, int rowA, int rowB){
        int[] rowTemp = matrix[rowA];
        matrix[rowA] = matrix[rowB];
        matrix[rowB] = rowTemp;
        return matrix;
    }

    private static int[][] swapColumns(int[][] matrix, int columnA, int columnB){
        int[] columnTemp = new int[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            columnTemp[i] = matrix[i][columnA];
            matrix[i][columnA] = matrix[i][columnB];
            matrix[i][columnB] = columnTemp[i];
        }
        return matrix;
    }



}
