package backtrack;

import board.logic.board.Operation;

import java.util.ArrayList;

/**
 * Created by ${gaboq} on 15/4/2018.
 */

public class Solver {

    private final ArrayList<Integer> NUMBERS = new ArrayList<>();

    public Solver(int lendth) {

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

    private ArrayList<Integer> sum(int target) {

        return sum_recursive(NUMBERS, target);
    }

    private ArrayList<Integer> sum_recursive(ArrayList<Integer> root, int target) {

    }

    private ArrayList<Integer> solve(int op) {
        return sum(10);
    }


    public static void main(String[] args) {

        Solver solution = new Solver(7);
        System.out.println(solution.solve(1));

    }

}
