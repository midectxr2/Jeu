package be.ac.umons.emile.jeu.logique;

import java.util.ArrayList;
public class Test {
    public static void main(String args[]) {
        Board board = new Board("filetest.txt");
        System.out.println(board.board[1][1]+"" +""+ board.height+" "+ ""+board.width);
    }
}

