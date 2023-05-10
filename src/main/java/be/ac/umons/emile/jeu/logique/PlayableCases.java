package be.ac.umons.emile.jeu.logique;

import javafx.scene.paint.Color;

public class PlayableCases extends Cases{

    /*Constructeur des pièces modifiables*/
    public PlayableCases(int x,int y) {
        super(x, y);
        setFill(Color.BLACK);
    }

    /*Permet de savoir si la case peut-être déplacée/modifiée ou non*/
    public boolean isMovable(){
        return true;
    }

    /*Idée pour définir les couleurs des cases, voir algo de sobel
    Les valeurs ne sont pas définitives c'est qu'un exemple
    */
    protected int[] color(){
        int[] rgb=new int[3];
        rgb[1]=165;
        rgb[2]=30;
        rgb[3]=75;
        return rgb;
    }



}
