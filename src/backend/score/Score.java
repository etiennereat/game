package backend.score;

//Biginteger
public class Score {
    private byte[] nb;
    private Unite unite;
    private int taille;
    private int TAILLE_MAX = 193;

    public Score() {
        init_nb();
        taille = 1;
        setUnite(Unite.$);
    }

    public Score(String nb){
        init_nb();
        taille = nb.length();
        for(int i=taille-1;i >=0;i--){
            this.nb[TAILLE_MAX - 1 - i] = (byte) Character.getNumericValue(nb.charAt(taille- i- 1));
        }
        setUnite(Unite.values()[(taille-1) / 3 ]);
    }

    public void add_score(Score score) {
        for (int i = TAILLE_MAX - score.taille; i < TAILLE_MAX; i++){
            add_bit(score.nb[i], i);
        }
    }

    //bit entre 0 et TAILLE_MAX
    //value entre 1 et 9
    private void add_bit(byte value, int bit) {
        if(value==0){
            return;
        }
        if ((192 - bit) + 1 > taille) {
            taille = 192 - bit + 1 ;
            nb[bit] = (byte) ((nb[bit] + value));
            setUnite(Unite.values()[(taille-1) / 3]);
        } else {
            if (nb[bit] + value > 9) {
                nb[bit] = (byte) ((nb[bit] + value) % 10);
                add_bit((byte) 1, bit - 1);
            } else {
                nb[bit] = (byte) ((nb[bit] + value));
            }
        }
    }

    private void init_nb() {
        nb = new byte[TAILLE_MAX];
        for (int i = 0; i < TAILLE_MAX; i++) {
            nb[i] = (byte) 0;
        }
    }

    public Unite getUnite() {
        return unite;
    }

    private void setUnite(Unite unite) {
        this.unite = unite;
    }

    public int get_taille() {
        return taille;
    }

    public String get_short_nb() {
        String short_nb = "";

        if (taille > unite.ordinal() * 3 + 2) {
            short_nb += String.valueOf((nb[TAILLE_MAX - 1 - unite.ordinal() * 3 - 2]));
        }
        if (taille > unite.ordinal() * 3 + 1) {
            short_nb += String.valueOf((nb[TAILLE_MAX - 1 - unite.ordinal() * 3 - 1]));
        }
        if (taille > unite.ordinal() * 3) {
            short_nb += String.valueOf((nb[TAILLE_MAX - 1 - unite.ordinal() * 3]));
        }
        if (unite != Unite.$) {
            short_nb += ',' + String.valueOf((nb[TAILLE_MAX - 1 - unite.ordinal() * 3 + 1])) + String.valueOf((nb[TAILLE_MAX - 1 -unite.ordinal() * 3 + 2])) + String.valueOf((nb[TAILLE_MAX - 1 -unite.ordinal() * 3 + 3]));
        }
        short_nb += " "+unite.name();
        return short_nb;
    }

    public String get_full_nb() {
        String full_nb = "";
        for (int i = taille -1 ; i >= 0; i--) {
            full_nb += String.valueOf(nb[TAILLE_MAX - 1 - i]);
        }
        full_nb += " "+Unite.$.name();
        return full_nb;
    }

    public String get_science_notation(){
        String science_nb = String.valueOf(nb[TAILLE_MAX - 1 - taille + 1]);
        if (taille - 2 >= 0) {
            science_nb += ',';
            science_nb += String.valueOf(nb[ TAILLE_MAX - 1 - taille + 2]);
        }
        if (taille - 3 >= 0) {
            science_nb += String.valueOf(nb[TAILLE_MAX - 1 - taille + 3]);
        }
        if (taille - 4 >= 0) {
            science_nb += String.valueOf(nb[TAILLE_MAX - 1 - taille + 4]);
        }

        science_nb += "×10";
        if(taille > 1){
            science_nb +=replace_pow(String.valueOf(taille));
        }
        science_nb += " "+Unite.$.name();
        return science_nb;
    }
    private String replace_pow(String string_to_up){
        String str = string_to_up.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");
        return str;
    }
}