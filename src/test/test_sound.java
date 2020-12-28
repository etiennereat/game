package test;

import son.Sound;

import javax.swing.*;

public class test_sound {
    public static void main(String[] argv) {
        Sound sound = new Sound("data/sound/test_musique.wav");
        sound.play();
    }
}
