package be.ac.umons.emile.jeu.logique;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public abstract class Cases extends Rectangle {
    private Pieces piece;

    private int Tile = 50;

    public boolean hasPiece(){
        return piece != null;
    }

    public Pieces getPiece(){
        return piece;
    }

    public void setPiece(Pieces piece){
        this.piece = piece;
    }

    protected int px;
    protected int py;
    public Cases(int x,int y){
        this.px=x;
        this.py=y;
        setWidth(Tile);
        setHeight(Tile);
        relocate(x * Tile, y * Tile);
        setStroke(Color.BLACK);
        setStrokeWidth(1);

    }
    public int getPX(){
        return px;
    }
    public int getPY(){
        return py;
    }
    public void setPX(int x){
        this.px=x;
    }
    /*Setter pour la coordonnée y*/
    public void setPY(int y){
        this.py=y;

    }
    public abstract boolean isMovable();

    protected abstract int[] color();




}