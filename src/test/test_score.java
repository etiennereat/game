package test;

import backend.score.Score;
import backend.son.Sound;

public class test_score {
    public static void main(String[] argv) {
        Score test = new Score("123456789");
        String affichage = test.get_short_nb();
        System.out.println(affichage+" "+test.getUnite());
        affichage = test.get_full_nb();
        System.out.println(affichage);
        affichage = test.get_science_notation();
        System.out.println(affichage);
    }
}
