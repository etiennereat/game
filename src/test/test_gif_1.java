package test;

import Ui.gif.AdaptingAnimation;
import Ui.gif.FactoryGif;
import Ui.gif.OneLoopGif;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class test_gif_1 extends JFrame{
    JPanel panel_test;
    AdaptingAnimation curentanime;
    test_gif_1(String title){
        super(title);
        Dimension dimension_screen = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(dimension_screen);
        setLayout(new BorderLayout());
        panel_test = new JPanel();
        panel_test.setBackground(Color.WHITE);
        add(panel_test,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        curentanime = new AdaptingAnimation("witch/fly",true,50);
        panel_test.add(curentanime.getLabel());
        curentanime.execute();
        setLocationRelativeTo(null);
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                do_spell();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void do_spell(){
        panel_test.removeAll();
        AdaptingAnimation anime = new AdaptingAnimation("witch/cast",false,100);
        panel_test.add(anime.getLabel());
        anime.execute();
        panel_test.setVisible(true);
        setVisible(true);
        anime.addActionListener(e -> {
            panel_test.removeAll();
            AdaptingAnimation anime2 = new AdaptingAnimation("witch/shoot",false,50);
            panel_test.add(anime2.getLabel());
            anime2.execute();
            panel_test.setVisible(true);
            setVisible(true);
            anime2.addActionListener(e1 -> {
                panel_test.removeAll();
                panel_test.add(curentanime.getLabel());
                panel_test.setVisible(true);
                setVisible(true);
            });
        });
    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new test_gif_1("test Ui.gif").setVisible(true));
    }
}
