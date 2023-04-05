package be.ac.umons.emile.jeu.logique;
import java.util.ArrayList;
public class Grid {
    Cases[][] grid=new Cases[3][3];
    ArrayList<Cases> cases=new ArrayList<>();

    /*Permet d'ajouter une pièce au bon endroit dans la grille (selon y seulement pour l'instant)
      Ne fonctionne que pour la ArrayList de Gridv1

     */
   /* public void addPiece(Pieces piece){
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

    /*Construction de la grille au cas où on utilise un tableau fixe

     */
    private void buildingGrid(){
        for(int i=0 ;i<grid.length ;i++){
            for(int j=0;j<grid[i].length;j++){
                grid[i][j]= new PlayableCases(i,j);
            }
        }
    }

    /*Affichage de la grille pour tableau fixe

     */
    public void printGrid(){
        for(int i=0 ;i<grid.length ;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j].value);
            }
            System.out.print("\n");
        }

    }

    /*Permet l'ajout d'une nouvelle pièce sur un tableau fixe

     */
    public void addPiece2(Pieces piece){
        for(ArrayList<PlayableCases>p:piece.piece) {
            for(Cases c:p) {
                for (int i = 0; i < grid.length; i++) {
                    if(c.getY()==i){
                        for(int j=0; j<grid[i].length;j++){
                            if(c.getX()==j){
                                grid[i][j]=c;
                            }
                        }
                    }

                }
            }
        }

    }




}
