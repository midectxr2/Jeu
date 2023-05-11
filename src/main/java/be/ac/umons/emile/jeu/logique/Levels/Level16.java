package be.ac.umons.emile.jeu.logique.Levels;

import be.ac.umons.emile.jeu.logique.DraggableApp;
import be.ac.umons.emile.jeu.logique.EmptyCases;
import be.ac.umons.emile.jeu.logique.Pieces;
import be.ac.umons.emile.jeu.logique.RotationApp;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level16 extends Application{public int height;
    public int width;
    private int x = 1;
    public double[][] board;
    VBox leftBox = new VBox();
    FlowPane piecePane= new FlowPane();
    private DraggableApp drag = new DraggableApp();
    private RotationApp rota;
    public ArrayList<Pieces> pieces = new ArrayList<>();
    public ArrayList<char[]> pos = new ArrayList<>();

    public Level16()  {
        try {
            String FileName = "res/level/level26.txt";
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
            board = new double[height][width];
            for (int i = 1; i < height + 1; i++) {
                for (int j = 0; j < width; j++) {
                    board[i - 1][j] = pos.get(i)[j] - 48;
                }
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

    public boolean hasValue(double[][] board) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkCase(int x, int y, Pieces piece) {
        for (int i = 0; i < piece.shape.size(); i++) {
            if (board[x + (int)piece.shape.get(i).getPX()][y + (int)piece.shape.get(i).getPY()] != 1) {
                return false;
            }
        }
        return true;
    }

    public BorderPane createContent() {
        Level16 jeu=new Level16();
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        root.setCenter(grid);
        piecePane.setHgap(10);
        piecePane.setVgap(5);

        for (int i = 0; i < jeu.height; i++) {
            RowConstraints row = new RowConstraints(50);
            grid.getRowConstraints().add(row);
        }
        for (int i = 0; i < jeu.width; i++) {
            ColumnConstraints col = new ColumnConstraints(50);
            grid.getColumnConstraints().add(col);
        }


        for (int i = 0; i < jeu.height; i++) {
            for (int j = 0; j < jeu.width; j++) {
                if (jeu.board[i][j] == 0) {
                    EmptyCases tile = new EmptyCases(j, i);
                    grid.add(tile, j, i);

                }
            }
        }

        for (Pieces c : jeu.pieces) {
            rota = new RotationApp(c);
            piecePane.getChildren().add(c);
            drag.makeDraggable(c,grid,root);
            rota.Rotation(c);

        }

        root.setRight(piecePane);

        return root;
    }
    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(createContent());
        stage.setTitle("Jeu");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
    }

    public static void main(String[] args){
        Application.launch(args);
    }

}
