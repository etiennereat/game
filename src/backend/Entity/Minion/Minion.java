package backend.Entity.Minion;

import backend.Entity.Entity;

public abstract class Minion extends Entity {
    etat_minion etat;
    public Minion(int x, int y) {
        super(x, y);
    }
}
