package test;

import Ui.gif.AdaptingAnimation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class test_adaptinganimation extends JFrame{
    public test_adaptinganimation(String title) {
        super(title);
        Dimension dimension_screen = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(dimension_screen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdaptingAnimation animation = new AdaptingAnimation("witch/fly",true,50);
        animation.execute();
        add(animation.getLabel());
        pack();
        setVisible(true);
    }




    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new test.test_adaptinganimation("test Ui.gif").setVisible(true));
    }
}
