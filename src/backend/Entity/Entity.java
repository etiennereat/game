package backend.Entity;

import javax.swing.*;

public abstract class Entity {
    protected int x,y;
    protected static JLabel label;

    public Entity(int x,int y){
        setX(x);
        setY(y);
    }

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

    public void setLabel(JLabel label) {
        Entity.label = label;
    }
    public abstract void nextStep();
}
