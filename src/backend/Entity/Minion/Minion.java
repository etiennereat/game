package backend.Entity.Minion;

import backend.Entity.Entity;

public abstract class Minion extends Entity {
    etat_minion etat;
    public Minion(int x, int y) {
        super(x, y);
        setEtat(etat_minion.INIT);
    }

    public etat_minion getEtat() {
        return etat;
    }

    public void setEtat(etat_minion new_etat) {
        updateEtat(new_etat);
    }
    private void updateEtat(etat_minion new_etat){
        switch(etat){
            case DEAD :
                break;
            case INIT :
            case RUN :
                etat = new_etat;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + etat);
        }
    }
}
