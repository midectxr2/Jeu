package be.ac.umons.emile.jeu.logique;
import java.util.ArrayList;
public class Grid {
    ArrayList<ArrayList<Cases>> grid=new ArrayList<>();
    ArrayList<Cases> cases=new ArrayList<>();

    /*Permet d'ajouter une pièce au bon endroit dans la grille (selon ly seulement pour l'instant

     */
    public void addPiece(Pieces piece){
        int yMax=piece.yMax();
        for (ArrayList<PlayableCases>p:piece.piece){
            for(Cases c:p){
                int y=c.getY();
                for(int i=0;i<=yMax;i++){
                    if(y==i){
                        cases.add(c);
                    }
                }
                grid.add(y,cases);

            }

        }

    }




}
