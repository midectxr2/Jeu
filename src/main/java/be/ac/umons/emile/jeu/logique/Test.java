package be.ac.umons.emile.jeu.logique;

import java.util.ArrayList;
public class Test {
    public static void main(String args[]){
        Pieces piece= new Pieces(3);
        piece.add(new PlayableCases(0,0));
        piece.add(new PlayableCases(1,0));
        piece.add(new PlayableCases(2,0));
        piece.add(new PlayableCases(0,1));

        piece.printPiece();
        System.out.print("\n");
        piece.printPiece();







    }
}

