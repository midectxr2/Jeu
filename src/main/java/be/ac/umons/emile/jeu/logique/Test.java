package be.ac.umons.emile.jeu.logique;

import java.util.ArrayList;
public class Test {
    public static void main(String args[]){
        int value = 1;
        ArrayList<PlayableCases> form= new ArrayList<>();
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                form.add(new PlayableCases(i, j, value));
            }
        }
        for(PlayableCases p:form){
            if (p.getX()==1 && p.getY()== 4)
                p.value= 0;
        }
        for (PlayableCases c:form){
            System.out.print(c.value);
        }
    }


}

