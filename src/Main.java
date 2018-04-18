import gameSolver.Solver;
import gameboard.GUI.KenkenFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*
                KenkenFrame frame = new KenkenFrame();
                frame.setVisible(true);
                frame.getkPanel().getBoard().printBoard();
                */
                Solver s = new Solver(19);
                s.dislay();
            }
        });

    }

}
