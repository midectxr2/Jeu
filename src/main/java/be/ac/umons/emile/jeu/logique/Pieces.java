package be.ac.umons.emile.jeu.logique;
import java.util.ArrayList;
public class Pieces {
    ArrayList<PlayableCases> tab= new ArrayList<>();
    private int value;
    public Pieces( int value ){
        this.value=value;
    }


    /*rotation de la pièce
     */
    public void rotatePiece(){
        for(PlayableCases c:tab){
            c.rotate();
        }
    }
    /*Fonction à implémenter pour déplacer les pièces

     */
    public void movePiece(){

    }
    /*Affiche les pièces mais ne prend pas en compte le placement selon les coord x
    !!à corriger!!
     */
    public void printPiece() {
        int l = 1;
        for (PlayableCases c : tab) {
            if (c.getY() < l) {
                System.out.print(value + " ");
            }
            else {
                System.out.print("\n");
                System.out.print(value+ " ");
                l++;
            }

        }
    }
    /*Permet d'ajouter des cases à la pièce*/
    public void add(PlayableCases cases){
        tab.add(cases);
    }




}