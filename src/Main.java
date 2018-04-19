import gameSolver.Solver;
import gameboard.GUI.KenkenFrame;

import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                KenkenFrame frame = new KenkenFrame();
                frame.setVisible(true);
                frame.getkPanel().getBoard().printBoard();

                //Solver s = new Solver(7);
                //System.out.println(Arrays.toString(s.getNumbers().keySet().toArray()));
            }
        });

    }

}
