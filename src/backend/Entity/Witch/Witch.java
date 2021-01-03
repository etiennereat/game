package backend.Entity.Witch;

import backend.Entity.Entity;

public class Witch extends Entity {
    etat_witch etat;
    action_witch curent_action;

    public Witch(int x, int y) {
        super(x, y);

    }

    //todo
    @Override
    public void nextStep() {

    }
}
