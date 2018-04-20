package gameboard.GUI;

import gameboard.logic.board.Generator;
import gameboard.logic.board.KenkenBoard;

import javax.sql.rowset.spi.XmlReader;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class KenkenFrame extends JFrame {

    private KenkenPanel kPanel;
    private JButton generatorButton;
    private JComboBox<Object> comboBox;
    private JTextField tf;

    public KenkenFrame(){


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("KenKen");
        //this.setResizable(false);
        this.setMinimumSize(new Dimension(850,750));

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

        comboBox = new JComboBox<>();
        tf = new JTextField(20);
        comboBox = new JComboBox<>();
        for (int i = 5; i <= 19 ; i++) {
            comboBox.addItem(i);
        }
        comboBox.addActionListener(e -> tf.setText(Objects.requireNonNull(comboBox.getSelectedItem()).toString()));


        generatorButton = new JButton("New Table");
        generatorButton.addActionListener( e -> {try{
            this.rebuildInterface((int) comboBox.getItemAt(comboBox.getSelectedIndex()));
        }catch (Exception exc){
            exc.printStackTrace();
        }});

        JButton saveTable = new JButton("Save Table");
        saveTable.addActionListener(e -> System.out.println("Jeje"));
        JButton openTable = new JButton("Load Table");
        openTable.addActionListener(e -> {
            try{
                FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
                fd.setDirectory("C:\\Tables");
                fd.setFile("*.xml");
                fd.setVisible(true);
                String filename = fd.getFile();
                if (filename == null)
                    System.out.println("You cancelled the choice");
                else
                    System.out.println("You chose " + filename);
            }catch (Exception ignored){}
        });

        JPanel windowPanel = new JPanel();
        windowPanel.setLayout(new FlowLayout());

        kPanel = new KenkenPanel(new KenkenBoard(8,8));


        windowPanel.add(kPanel);
        windowPanel.add(comboBox);
        windowPanel.add(generatorButton);
        windowPanel.add(saveTable);
        windowPanel.add(openTable);
        this.add(windowPanel);

    }

    public void rebuildInterface(int dimension){
        KenkenBoard generatedboard = new KenkenBoard(dimension,dimension);
        kPanel.setBoard(generatedboard);
        int fontSize = Generator.calculateFontSize(dimension);
        kPanel.setFontSize(fontSize);
        kPanel.setGapY(fontSize);
        kPanel.repaint();
    }

    public KenkenPanel getkPanel(){
        return kPanel;
    }

}
