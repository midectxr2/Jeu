package be.ac.umons.emile.jeu.logique;

import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Test {

    public static void main(String args[]){
        int height;
        int width;
        int x = 1;
        int[][] board;
        ArrayList<Pieces> pieces = new ArrayList<>();
        ArrayList<char[]> pos = new ArrayList<>();
        try {
            String FileName = "res/level/level14.txt";
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
            height = pos.get(0)[1] - 48;
            width = pos.get(0)[0] - 48;
            board = new int[height][width];
            for (int i = 1; i < height + 1; i++) {
                for (int j = 0; j < width; j++) {
                    board[i - 1][j] = pos.get(i)[j] - 48;
                    System.out.print( board[i - 1][j]);
                }
                System.out.print("\n");

            }

            for (int i = height + 1; i < pos.size(); i++) {
                for (int j = 0; j < pos.get(i).length; j++) {
                    pieces.add(new Pieces(pos.get(i)[j]));
                }
            }
        } catch (IOException e) {
            System.out.print("Gros con");

        }



   }
}

