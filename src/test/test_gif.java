package test;

import gif.FactoryGif;

import javax.swing.*;
import java.awt.*;

public class test_gif extends JFrame{
    test_gif(String title){
        super(title);
        setPreferredSize(new Dimension(1080,720));
        JPanel panel_test = new JPanel();
        panel_test.setBackground(Color.RED);
        add(panel_test);
        //setUndecorated(true);
        panel_test.add(FactoryGif.get_label_gif("data/gif/witch/fly_witch.gif"));
        panel_test.add(FactoryGif.get_label_gif("data/gif/witch/punch_witch.gif"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new test_gif("test gif").setVisible(true));
    }
}
