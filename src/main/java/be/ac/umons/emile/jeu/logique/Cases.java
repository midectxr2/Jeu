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
    private static final int tileSize=50;
    protected double px;
    protected double py;
    public Cases(int x,int y){
        this.px=x;
        this.py=y;
        setWidth(tileSize);
        setHeight(tileSize);
        relocate(px * tileSize, py*tileSize);
        setStroke(Color.BLACK);
        setStrokeWidth(1);

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