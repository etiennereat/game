package Ui.gif;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class AdaptingAnimation extends SwingWorker<Integer,Integer> {

    private JLabel label_anime;

    private int nb_current_frame;
    private ImageIcon current_frame;

    private String filename="/image ";
    private String  directory = "data/picture/";

    private int delay;
    private ReentrantLock lock;
    private Boolean loop=true;
    private state_anime state;


    public AdaptingAnimation(String anime_name,Boolean loop,int delay) {
        lock = new ReentrantLock();
        label_anime = new JLabel();
        nb_current_frame = 0;
        directory+=anime_name;
        this.loop=loop;
        state =state_anime.INIT;
        set_delay(delay);
    }


    private int anime(){
        while (state != state_anime.END){
            //wait if anime is FREEZE
            lock.lock();
            assert(state == state_anime.RUNNING);
            lock.unlock();
            load_next_frame();
            label_anime.setIcon(current_frame);
            label_anime.updateUI();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    //la fonction qui lance l anime en tache de fond
    @Override
    protected Integer doInBackground() throws Exception {
        update_state(state_anime.RUNNING);
        return anime();
    }

    private void load_next_frame(){
        try {
            current_frame = new ImageIcon(ImageIO.read(new File(directory+filename+"("+nb_current_frame+").png")));
            nb_current_frame++;
        }
        //on arrive a la fin de l animation
        catch (IOException e) {
            if(loop){
                nb_current_frame=0;
                load_next_frame();
            }
            else{
                cancel_anime();
                System.out.println("fin de l'animation !");
            }
        }

    }

    public JLabel getLabel(){
        return label_anime;
    }
    public void set_delay(int delay){
        this.delay = delay;
    }

    public void cancel_anime(){
        update_state(state_anime.END);
    }

    public void freeze_anime(){
        lock.lock();
        update_state(state_anime.FREEZE);
    }
    public void unfreeze_anime(){
        lock.unlock();
        update_state(state_anime.RUNNING);
    }

    private void update_state(state_anime new_state){
        switch(state){
            case INIT :
            case RUNNING :
            case FREEZE :
                state=new_state;
            case END :
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }

}