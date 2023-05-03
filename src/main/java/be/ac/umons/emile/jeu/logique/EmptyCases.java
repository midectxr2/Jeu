package be.ac.umons.emile.jeu.logique;

import javafx.scene.paint.Color;

public class EmptyCases extends Cases {

    private int value;

    public EmptyCases(int x, int y) {
        super(x , y);
        setFill(Color.valueOf("#582"));
    }


    /*Permet de savoir si l'on peut bouger la case

     */
    public boolean isMovable() {
        return false;
    }

    /*Idée pour définir les couleurs des cases, voir algo de sobel
      Les valeurs ne sont pas définitives c'est qu'un exemple
     */
    protected int[] color(){
        int[] rgb=new int[3];
        rgb[1]=240;
        rgb[2]=185;
        rgb[3]=320;
        return rgb;

    }
    public void rotate(){}

}