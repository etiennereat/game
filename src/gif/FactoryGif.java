package gif;

import javax.swing.*;
import java.net.URL;

public class FactoryGif{
    public static JLabel get_label_gif(String path){
        Icon icon = new ImageIcon(path);
        return new JLabel(icon);
    }
}
