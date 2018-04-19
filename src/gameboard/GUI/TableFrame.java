package gameboard.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TableFrame extends JFrame {

    private JComboBox<Integer> comboBox;
    private JTextField tf;
    private JButton generate;
    private JLabel label;

    TableFrame(KenkenFrame frame){
        this.setTitle("Generate Table");
        this.setMinimumSize(new Dimension(400,100));
        this.setLayout(new FlowLayout());

        label = new JLabel("Select Table Dimensions");

        tf = new JTextField(20);
        comboBox = new JComboBox<>();
        for (int i = 5; i <= 19 ; i++) {
            comboBox.addItem(i);
        }
        comboBox.addActionListener(e -> tf.setText(Objects.requireNonNull(comboBox.getSelectedItem()).toString()));

        generate = new JButton("create");
        generate.addActionListener(e -> {

            try{
                frame.rebuildInterface(comboBox.getItemAt(comboBox.getSelectedIndex()));
            }catch (Exception ignored){
                ignored.printStackTrace();
            }
        });


        comboBox.setEditable(false);
        this.add(label);
        this.add(comboBox);
        this.add(generate);
        this.setVisible(true);
    }



}
