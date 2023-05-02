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

    protected int x;
    protected int y;
    public Cases(int x, int y){

        setWidth(Main.TILE_SIZE);
        setHeight(Main.TILE_SIZE);
        relocate(x * Main.TILE_SIZE, y*Main.TILE_SIZE);
        setStroke(Color.WHITE);


        this.x=x;
        this.y=y;

    }





    public abstract boolean isMovable();

    protected abstract int[] color();

    public abstract void rotate();


}