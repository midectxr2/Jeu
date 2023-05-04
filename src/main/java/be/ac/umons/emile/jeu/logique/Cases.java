package be.ac.umons.emile.jeu.logique;

import be.ac.umons.emile.jeu.javafx.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public abstract class Cases extends Rectangle {
    private Pieces piece;

    public boolean hasPiece(){
        return piece != null;
    }

    public Pieces getPiece(){
        return piece;
    }

    public void setPiece(Pieces piece){
        this.piece = piece;
    }

    protected double px;
    protected double py;
    public Cases(double x,double y){
        this.px=x;
        this.py=y;
        setWidth(Main.TILE_SIZE);
        setHeight(Main.TILE_SIZE);
        relocate(x * Main.TILE_SIZE, y*Main.TILE_SIZE);
        setStroke(Color.WHITE);

    }
    public double getPX(){
        return px;
    }
    public double getPY(){
        return py;
    }
    public void setPX(double x){
        this.px=x;
    }
    /*Setter pour la coordonnée y*/
    public void setPY(double y){
        this.py=y;

    }
    public abstract boolean isMovable();

    protected abstract int[] color();




}