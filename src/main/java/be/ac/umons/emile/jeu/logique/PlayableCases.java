package be.ac.umons.emile.jeu.logique;

public class PlayableCases extends Cases{
    private int x;
    private int y;

    protected int value;
    /*Constructeur des pièces modifiables*/
    public PlayableCases(int x, int y) {
        super(x, y, 1);
    }

    /*Getter pour la coordonnée x*/
    public int getX(){
        return this.x;
    }
    /*Getter pour la coordonnée y*/
    public int getY(){return this.y;}

    /*Permet de savoir si la case peut-être déplacée/modifiée ou non*/
    public boolean isMovable(){
        return true;
    }
    /*Setter pour la coordonnée x*/
    public int setX(int x){
        this.x=x;
        return x;
    }
    /*Setter pour la coordonnée y*/
    public int setY(int y){
        this.y=y;
        return this.y;
    }
    /*Changement de place d'une case permettant la rotation d'une pièce*/
    public void rotate() {
        int temp=0;
        temp=this.x;
        this.x = -this.y;
        this.y=temp;
    }
}
