package test;

import javax.swing.*;

public class test_gif extends JFrame{
    test_gif(String title){
        super(title);
    }
    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new test_gif("Dowloader").setVisible(true));
    }
}
