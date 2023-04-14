package be.ac.umons.emile.jeu.logique;

public class Board {
    private int height;
    private int width;
    private PlayableCases[][] board;


    public Board(int n, int p){
        height = p;
        width = n;
        board = new PlayableCases[width][height];

        for (int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                board[i][j] = new PlayableCases(j,i,0);
            }
        }

    }

}