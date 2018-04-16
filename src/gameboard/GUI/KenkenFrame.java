package gameboard.GUI;

import gameboard.logic.board.KenkenBoard;

import javax.swing.*;
import java.awt.*;

public class KenkenFrame extends JFrame {

    private KenkenPanel kPanel;

    public KenkenFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("KenKen");
        this.setMinimumSize(new Dimension(700,700));

        JPanel windowPanel = new JPanel();
        windowPanel.setLayout(new FlowLayout());
        windowPanel.setPreferredSize(new Dimension(800,600));

        kPanel = new KenkenPanel(new KenkenBoard(5,5));

        windowPanel.add(kPanel);
        this.add(windowPanel);

    }

    public void rebuildInterface(int dimension){
        KenkenBoard generatedboard = new KenkenBoard(dimension,dimension);
        kPanel.setBoard(generatedboard);
        kPanel.setFontSize(14);
        kPanel.repaint();
    }

    public KenkenPanel getkPanel(){
        return kPanel;
    }

}
