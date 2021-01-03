package test;

import Ui.gif.FactoryGif;
import backend.Entity.Witch.etat_witch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class test_gif_2 extends JFrame {
        JPanel panel_test;
        JLabel gif;
        etat_witch etat = etat_witch.INIT;
        int y=500;
        test_gif_2(String title) {
            super(title);
            Dimension dimension_screen = Toolkit.getDefaultToolkit().getScreenSize();
            setPreferredSize(dimension_screen);
            panel_test = new JPanel(null);
            panel_test.setBackground(Color.RED);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gif = FactoryGif.get_loop_gif("data/gif/witch/fly_witch.gif");
            gif.setBounds(0, y,520,300);
            panel_test.add(gif);
            panel_test.revalidate();
            panel_test.repaint();
            add(panel_test);
            setLocationRelativeTo(null);
            pack();
            setVisible(true);
            addKeyListener(new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e) {
                    if( e.getKeyCode() == KeyEvent.VK_SPACE){
                        System.out.println("je press");
                        etat = etat_witch.FLY;
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    if( e.getKeyCode() == KeyEvent.VK_SPACE){
                        System.out.println("je relache");
                        etat = etat_witch.FALL;
                    }
                }
            });
            new Thread(() -> {
                while(true){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    gif.setBounds(0, y,520,300);
                    switch (etat) {
                        case FALL:
                            if (y != 500) {
                                y++;
                            } else {
                                etat = etat_witch.HOVER;
                            }
                            break;
                        case FLY:
                            if (y != 0) {
                                y--;
                            }
                            break;
                    }
                }
            }).start();
        }
        public static void main(String[] argv) {
            SwingUtilities.invokeLater(() -> new test.test_gif_2("test Ui.gif").setVisible(true));
        }
    }
