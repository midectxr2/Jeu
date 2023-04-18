package be.ac.umons.emile.jeu.logique;

import java.util.ArrayList;

public class Form {
    public ArrayList<PlayableCases> form=new ArrayList<>();
    public int value;

    public Form(int value){
        this.value=value;


        if(value==1){
            form.add(new PlayableCases(0,0,value));
        }
    }

}
