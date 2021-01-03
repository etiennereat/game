package backend.Entity;

import backend.Entity.item.loot;

import javax.swing.*;

public class Entity {
    protected int x,y;
    protected static JLabel label;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public static JLabel getLabel() {
        return label;
    }

    public static void setLabel(JLabel label) {
        loot.label = label;
    }
}
