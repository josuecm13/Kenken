package gameboard.GUI;

import gameboard.logic.board.KenkenBoard;

import javax.swing.*;
import java.awt.*;

public class KenkenFrame extends JFrame {

    private KenkenPanel kPanel;

    public KenkenFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("KenKen");
        this.setResizable(false);
        this.setMinimumSize(new Dimension(700,700));

        /*
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Open File");
        JMenu newTable = new JMenu("new KenKen");
        JMenuItem save = new JMenuItem("Save Table");

        file.add(newTable);
        file.add(load);
        file.add(save);
        menuBar.add(file);
        this.setJMenuBar(menuBar);
        */

        JButton saveButton = new JButton("Save Kenken");



        JPanel windowPanel = new JPanel();
        windowPanel.setLayout(new FlowLayout());
        windowPanel.setPreferredSize(new Dimension(800,600));

        kPanel = new KenkenPanel(new KenkenBoard(7,7));

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
