package be.ac.umons.emile.jeu.logique;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
    public int height;
    public int width;
    private int x = 1;
    public int[][] board;
    public ArrayList <Pieces> pieces = new ArrayList <>();
    public ArrayList<char[]> pos = new ArrayList<char[]>();
    public Board(String FileName) {
        try {

            // Le fichier d'entrée
            File file = new File(FileName);
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                char[] tab = new char[line.length()];
                // ajoute la ligne au buffer
                tab = line.toCharArray();
                pos.add(tab);
            }
            fr.close();
            height = pos.get(0)[1]-48;
            width = pos.get(0)[0]-48;
            board = new int[height][width];

            //les char suivant donne les données des cases(remplie ou vide)

            for (int i = 1; i < height + 1; i++) {
                for (int j = 0; j < width; j++) {
                    board[i-1][j] = pos.get(i)[j]-48;
                }
            }
            for(int i = height + 1; i < pos.size(); i++){
                for(int j = 0; j < pos.get(i).length; j++){
                    pieces.add(new Pieces(pos.get(i)[j]));
                }
            }



        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    public boolean hasValue(ArrayList<int[]>board){
        for(int i=0; i<board.size();i++){
            for(int j=0;j<board.get(i).length;j++){
                if (board.get(i)[j]==1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCase(int x, int y,Pieces piece){
        for(int i=0;i<piece.shape.size();i++){
            if(board[x+ piece.shape.get(i).getX()][y+piece.shape.get(i).getY()]!=1){
                return false;
            }
        }
        return true;
    }
}