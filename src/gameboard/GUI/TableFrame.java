package gameboard.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TableFrame extends JFrame {

    private JComboBox comboBox;
    private JTextField tf;
    private JButton generate;
    private JLabel label;

    TableFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Generate Table");
        this.setLayout(new FlowLayout());

        tf = new JTextField(20);
        comboBox = new JComboBox();
        for (int i = 5; i < 19 ; i++) {
            comboBox.addItem(i);
        }
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(Objects.requireNonNull(comboBox.getSelectedItem()).toString());
            }
        });
        comboBox.setEditable(false);

        this.add(comboBox);
    }



}
