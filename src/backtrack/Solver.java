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

    private void sum(int target, int length) {
        sum_recursive(NUMBERS.root, target, length);
    }

    private void sum_recursive(Node node, int target, int length) {
        if (node != null) {
            int val = node.value;
            if (val > target) {
                node.visited = true;
                sum_recursive(node.left, target, length);
            } else {

            }
        }
    }


    public static void main(String[] args) {
        Solver solution = new Solver(7);
        solution.NUMBERS.dfs(solution.NUMBERS.root);

        System.out.println();
        solution.sum(10, 2);
    }


}
