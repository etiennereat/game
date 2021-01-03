package Ui.gif;

import javax.swing.*;
import java.awt.*;

public class FactoryGif{
    public static OneLoopGif get_one_loop_gif(String path){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        ImageIcon newIcon = new ImageIcon(img);
        img.flush();
        return new OneLoopGif(newIcon);
    }
    public static JLabel get_loop_gif(String path){
        Icon icon = new ImageIcon(path);
        return new JLabel(icon);
    }
}
