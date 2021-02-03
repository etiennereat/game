package test;

import backend.score.Score;
import backend.score.Unite;

public class test_score {
    public static void main(String[] argv) throws Score.ScoreException {
        Score test = new Score("123456789");
        String affichage = test.get_short_nb();
        System.out.println(affichage);
        affichage = test.get_full_nb();
        System.out.println(affichage);
        affichage = test.get_science_notation();
        System.out.println(affichage);

        Score test_2 = new Score("111111111");
        Score score_add = new Score("888888889");
        test_2.add_score(score_add);
        affichage = test_2.get_full_nb();
        System.out.println(affichage);

        Score test_3 = new Score("111000");
        Score score_sub = new Score("1");
        test_3.sub_score(score_sub);
        affichage = test_3.get_full_nb();
        System.out.println(affichage);

        Score test_4 = new Score(1000, Unite.YZ);
        affichage = test_4.get_short_nb();
        System.out.println(affichage);
        affichage = test_4.get_science_notation();
        System.out.println(affichage);
        affichage = test_4.get_full_nb();
        System.out.println("  "+affichage);

        score_add = new Score(998, Unite.YY);
        affichage = score_add.get_full_nb();
        System.out.println(affichage);

        test_4.add_score(score_add);
        affichage = test_4.get_full_nb();
        System.out.println(affichage);
    }
}
