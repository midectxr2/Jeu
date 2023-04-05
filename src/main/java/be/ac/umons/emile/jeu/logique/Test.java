package be.ac.umons.emile.jeu.logique;

import java.util.ArrayList;
public class Test {
    public static void main(String args[]){
        Grid grid= new Grid();
        Pieces piece= new Pieces(3);
        piece.addCases(new PlayableCases(0,0));
        piece.addCases(new PlayableCases(1,0));
        piece.addCases(new PlayableCases(2,0));
        grid.addPiece2(piece);
        grid.printGrid();











    }
}

