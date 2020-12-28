package Ui.item;

import Ui.gif.FactoryGif;
import Ui.gif.OneLoopGif;
import son.Sound;

import javax.swing.*;

public abstract class loot {
    protected static JLabel label;
    protected static int nbLootShow;
    protected String pathGif;
    protected int x,y;
    protected etat_loot etat;
    protected Sound son;

    public loot(int x,int y){
        etat = etat_loot.INIT;
        incrementNbLootShow();
        setX(x);
        setY(y);
        setLabel(FactoryGif.get_loop_gif(pathGif));
    }
    public etat_loot getEtat() {
        return etat;
    }

    public void setEtat(etat_loot etat) {
        updateEtat(etat);
    }

    protected etat_loot updateEtat(etat_loot new_etat){
        switch(etat){
            case INIT:
            case LOOTABLE:
                etat = new_etat;
                break;
            case LOOTED:
            case DESTROY:
                break;
        }
        return etat;
    }


    public static JLabel getLabel() {
        return label;
    }

    public static void setLabel(JLabel label) {
        loot.label = label;
    }

    public static int getNbLootShow() {
        return nbLootShow;
    }

    public static void incrementNbLootShow(){
        nbLootShow++;
    }
    public static void decrementNbLootShow(){
        nbLootShow--;
    }

    public String getPath_gif() {
        return pathGif;
    }

    public void setPath_gif(String path_gif) {
        this.pathGif = path_gif;
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
}

