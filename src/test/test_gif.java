package test;

import gif.FactoryGif;

import javax.swing.*;
import java.awt.*;

public class test_gif extends JFrame{
    test_gif(String title){
        super(title);
        JPanel panel_test = new JPanel();
        panel_test.setBackground(Color.RED);
        add(panel_test);
        JLabel gif = FactoryGif.get_label_gif("data/gif/witch/punch_witch.gif");
        panel_test.add(gif);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(16 * 50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                JLabel gif = FactoryGif.get_label_gif("data/gif/witch/fly_witch.gif");
                panel_test.removeAll();
                panel_test.add(gif);
                setVisible(true);
            }
        }.start();
    }
    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new test_gif("test gif").setVisible(true));
    }
}
