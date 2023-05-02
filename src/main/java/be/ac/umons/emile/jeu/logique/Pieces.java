package be.ac.umons.emile.jeu.logique;
import be.ac.umons.emile.jeu.javafx.Main;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
public class Pieces extends StackPane {
    public ArrayList<PlayableCases> shape=new ArrayList<>();
    public int value;

    public Pieces() {

            shape.add(new PlayableCases(1,0,1));
            shape.add(new PlayableCases(1,1,1));
            shape.add(new PlayableCases(1,2,1));

            getChildren().addAll(shape);

    }




    /*rotation de la pièce
     */
    public void rotatePiece() {
        for(PlayableCases c:shape){
            c.rotate();
        }
    }

    /*Fonction à implémenter pour déplacer les pièces

     */
    public void movePiece() {

    }

    /*Affiche les pièces mais ne prend pas en compte le placement selon les coord x
    !!à corriger!!
     */

    /*Permet d'obtenir le y max d'une pièce

     */



}