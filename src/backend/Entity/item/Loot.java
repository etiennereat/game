package backend.Entity.item;

import Ui.gif.FactoryGif;
import backend.Entity.Entity;
import backend.son.Sound;

public abstract class Loot extends Entity {
    protected static int nbLootShow;
    protected String pathGif;
    protected etat_loot etat;
    protected Sound son;

    public Loot(int x,int y){
        super(x, y);
        etat = etat_loot.INIT;
        incrementNbLootShow();
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

    //todo ?
    public void nextStep(){

    }
}

