package be.ac.umons.emile.jeu.logique;

public class EmptyCases extends Cases{
    private int x;
    private int y;

    private int value;
    public EmptyCases(int x,int y){
        this.x=x;
        this.y=y;
        this.value=0;

    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean isMovable(){
        return false;
    }
}

