package be.ac.umons.emile.jeu.logique;

public class EmptyCases extends Cases{
    private int x;
    private int y;

    private int value;
    public EmptyCases(int x,int y){
        super(x,y,0);

    }
    /*getter de la coordonnée x

     */
    public int getX(){
        return this.x;
    }
    /*getter de la coordonnée y

     */
    public int getY(){
        return this.y;
    }
    /*Permet de savoir si l'on peut bouger la case

     */
    public boolean isMovable(){
        return false;
    }
}

