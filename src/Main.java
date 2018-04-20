import gameSolver.Solver;
import gameboard.GUI.KenkenFrame;
import gameboard.logic.shapes.Shape;

import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                KenkenFrame frame = new KenkenFrame();
                frame.setVisible(true);

            }
        });
    }

    public static void printBoard(Shape[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                System.out.print(board[i][j].getObjective() + board[i][j].getOperation().getSymbol() + "\t");
            }
            System.out.println("");
        }
    }

}
