package backtrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ${gaboq} on 15/4/2018.
 */

public class Solver {

    private final Tree NUMBERS;

    public Solver(int lendth) {
        NUMBERS = new Tree();
        numbersArray(lendth);

    }

    private void numbersArray(int lendth) {
        int indice = 10;
        for (int i = 0; i < lendth; i++) {
            if (i < 9) {
                NUMBERS.add(i + 1);
            } else {
                NUMBERS.add(i + 1 - indice++);
                indice++;
            }
        }
    }

    /*
    public static void main(String[] args) {
        Solver solution = new Solver(7);
        solution.NUMBERS.dfs(solution.NUMBERS.root);
        System.out.println();
    }
    */


}
