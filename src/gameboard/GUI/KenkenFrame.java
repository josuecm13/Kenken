package gameboard.GUI;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import gameSolver.Solver;
import gameboard.logic.board.Generator;
import gameboard.logic.board.KenkenBoard;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class KenkenFrame extends JFrame{

    private KenkenPanel kPanel;
    private JComboBox<Object> comboBox;
    private JComboBox<Boolean> randComboBox;
    private FileReader reader;
    private final XStream xStream;
    private PrintWriter out;
    private String xml;

    public KenkenFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("KenKen");
        //this.setResizable(false);
        this.setMinimumSize(new Dimension(700,760));
        xStream = new XStream(new DomDriver());

        kPanel = new KenkenPanel(new KenkenBoard(5,5,false));

        comboBox = new JComboBox<>();
        JTextField tf = new JTextField(20);
        comboBox = new JComboBox<>();
        for (int i = 5; i <= 19 ; i++) {
            comboBox.addItem(i);
        }
        //comboBox.addActionListener(e -> tf.setText(Objects.requireNonNull(comboBox.getSelectedItem()).toString()));

        randComboBox = new JComboBox<>();
        randComboBox.addItem(false);
        randComboBox.addItem(true);

        JButton generatorButton = new JButton("New Table");
        generatorButton.addActionListener(e -> {try{
            this.rebuildInterface((int) comboBox.getItemAt(comboBox.getSelectedIndex()), true);
        }catch (Exception exc){
            exc.printStackTrace();
        }});

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(e ->{
            FrameUpdater updater = new FrameUpdater(new Solver(kPanel.getBoard(),kPanel.getBoard().getNumRows()),this);
            Thread t = new Thread(updater);
            t.start();

        });

        JButton saveTable = new JButton("Save Table");
        saveTable.addActionListener(e -> {
            try{
                FileDialog fd = new FileDialog(this, "Save Table", FileDialog.SAVE);
                fd.setDirectory("\\Tables");
                fd.setFile("Table.xml");
                fd.setVisible(true);
                String name = fd.getFile();
                out = new PrintWriter(fd.getDirectory() + name);
                ArrayList<String> data = new ArrayList<>();
                xml = xStream.toXML(kPanel.getBoard());
                data.add(xml);
                out.println(xml);
                out.close();
            }catch (Exception ignored){

            }
        }
        );

        JButton openTable = new JButton("Load Table");
        openTable.addActionListener(e -> {
            try{
                FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
                fd.setDirectory("\\Tables");
                fd.setFile("*.xml");
                fd.setVisible(true);
                String filename = fd.getFile();
                if (filename == null)
                    System.out.println("You cancelled the choice");
                else{
                    reader = new FileReader(fd.getDirectory()+filename);
                    KenkenBoard board = (KenkenBoard) (xStream.fromXML(reader));
                    board.resetBoard();
                    kPanel.setBoard(board);
                    rebuildInterface(board.getNumColums(), false);
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        });

        JPanel windowPanel = new JPanel();
        windowPanel.setLayout(new FlowLayout());

        JLabel lbl = new JLabel("ケンケン (KenKen)");
        lbl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));

        windowPanel.add(lbl);
        windowPanel.add(kPanel);
        windowPanel.add(comboBox);
        windowPanel.add(randComboBox);
        windowPanel.add(generatorButton);
        windowPanel.add(saveTable);
        windowPanel.add(openTable);
        windowPanel.add(solveButton);
        this.add(windowPanel);

    }

    public void rebuildInterface(int dimension,boolean newTable){
        if(newTable){
            KenkenBoard generatedboard = new KenkenBoard(dimension,dimension,randComboBox.getItemAt(randComboBox.getSelectedIndex()));
            kPanel.setBoard(generatedboard);
        }
        int fontSize = Generator.calculateFontSize(dimension);
        int numFontSize = Generator.calculateNumFontSize(dimension);
        kPanel.setFontSize(fontSize);
        kPanel.setGapY(fontSize);
        kPanel.setNumConfiguration(numFontSize,numFontSize/2,(int) (numFontSize+(numFontSize*0.3)));
        kPanel.repaint();
    }

    public KenkenPanel getkPanel(){
        return kPanel;
    }

    public void update(int[][] matrix){
        kPanel.setNumbers(matrix);
    }

    private class FrameUpdater implements Runnable{

        private Solver solver;

        FrameUpdater(Solver solver,KenkenFrame frame){
            this.solver = solver;
            solver.setView(frame);
            solver.generatePermutations(kPanel.getBoard().getShapeboard());
        }

        @Override
        public void run() {

            solver.solve();
        }

    }

}
