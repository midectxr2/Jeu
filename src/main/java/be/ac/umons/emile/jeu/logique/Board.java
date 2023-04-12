package be.ac.umons.emile.jeu.logique;

public class Board {
    private int height;
    private int width;
    private int [][] board;


    public Board(int n, int p){
        height = p;
        width = n;
        board = new int[width][height];

        for (int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                board[i][j] = 0;
            }
        }
        for (int x = 10; x < width/2; x++){
            for (int y = 10; y < height/2; y++){
                board[x][y] = -1;
            }
        }

    }

}