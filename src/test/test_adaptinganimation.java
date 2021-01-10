package test;

import Ui.gif.AdaptingAnimation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class test_adaptinganimation extends JFrame{
    public test_adaptinganimation(String title) {
        super(title);
        Dimension dimension_screen = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(dimension_screen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdaptingAnimation animation = new AdaptingAnimation("witch/fly",true,50);
        add(animation.getLabel());
        animation.addActionListener(e -> {
            System.out.println("je passe");
        });
        animation.execute();
        pack();
        setVisible(true);
        final boolean[] freeze = {false};
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(!freeze[0]){
                    animation.freeze_anime();
                    freeze[0] = !freeze[0];
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(freeze[0]) {
                    animation.unfreeze_anime();
                }
                freeze[0] = !freeze[0];
            }
        });

    }




    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new test.test_adaptinganimation("test Ui.gif").setVisible(true));
    }
}
