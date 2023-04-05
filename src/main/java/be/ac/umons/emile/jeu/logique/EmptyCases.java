package be.ac.umons.emile.jeu.logique;

public class EmptyCases extends Cases {
    private int x;
    private int y;

    private int value;

    public EmptyCases(int x, int y) {
        super(x, y, 0);

    }

    /*getter de la coordonnée x

     */
    public int getX() {
        return this.x;
    }

    /*getter de la coordonnée y

     */
    public int getY() {
        return this.y;
    }

    /*Permet de savoir si l'on peut bouger la case

     */
    public boolean isMovable() {
        return false;
    }

    /*Idée pour définir les couleurs des cases, voir algo de sobel
      Les valeurs ne sont pas définitives c'est qu'un exemple
     */
    private int[] emptyCasesColor(){
        int[] rgb=new int[3];
        rgb[1]=240;
        rgb[2]=185;
        rgb[3]=320;
        return rgb;

    }
}