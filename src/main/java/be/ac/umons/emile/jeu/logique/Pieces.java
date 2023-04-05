package be.ac.umons.emile.jeu.logique;
import java.util.ArrayList;
import java.util.List;
public class Pieces {
   ArrayList<ArrayList<PlayableCases>> piece = new ArrayList<>();
    ArrayList<PlayableCases> cases=new ArrayList<>();
    private int value;

    public Pieces(int value) {

        this.value = value;
    }


    /*rotation de la pièce
     */
    public void rotatePiece() {
        for (PlayableCases c : cases) {
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
    public void printPiece() {
        int l = 1;
        for (PlayableCases c : cases) {
            if (c.getY() < l) {
                System.out.print(value + " ");
            } else {
                System.out.print("\n");
                System.out.print(value + " ");
                l++;
            }

        }
    }

    /*Permet d'ajouter des cases à la pièce*/
    public void addCases( PlayableCases object) {
        cases.add(object);
        piece.add(object.getY(), cases);
    }
    /*Permet d'obtenir le y max d'une pièce

     */
    public int yMax(){
        int max=0;
        for(ArrayList<PlayableCases> p:piece){
            for(Cases c: p){
                if (c.getY()>max){
                    max=c.getY();
                }

            }
        }
        return max;
    }



}