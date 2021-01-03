package test;

import Ui.gif.FactoryGif;
import Ui.gif.OneLoopGif;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class test_gif_1 extends JFrame{
    JPanel panel_test;
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
        JLabel gif = FactoryGif.get_loop_gif("data/gif/witch/fly_witch.gif");
        panel_test.add(gif);
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
        OneLoopGif gif = FactoryGif.get_one_loop_gif("data/gif/witch/test_cast_witch.gif");
        panel_test.add(gif);
        panel_test.setVisible(true);
        setVisible(true);
        gif.addActionListener(e -> {
            OneLoopGif gif1 = FactoryGif.get_one_loop_gif("data/gif/witch/test_shoot_witch.gif");
            panel_test.removeAll();
            panel_test.add(gif1);
            panel_test.setVisible(true);
            setVisible(true);
            gif1.addActionListener(e1 -> {
                JLabel gif11 = FactoryGif.get_loop_gif("data/gif/witch/fly_witch.gif");
                panel_test.removeAll();
                panel_test.add(gif11);
                panel_test.setVisible(true);
                setVisible(true);
            });
        });
    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new test_gif_1("test Ui.gif").setVisible(true));
    }
}
