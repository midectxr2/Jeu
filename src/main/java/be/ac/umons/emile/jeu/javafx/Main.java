package be.ac.umons.emile.jeu.javafx;

import be.ac.umons.emile.jeu.logique.Cases;
import be.ac.umons.emile.jeu.logique.EmptyCases;
import be.ac.umons.emile.jeu.logique.Pieces;
import be.ac.umons.emile.jeu.logique.PlayableCases;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int TILE_SIZE = 50;
    public static final int PLAYABLE_WIDTH = 6;
    public static final int PLAYABLE_HEIGHT = 6;

    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();


    private Parent createContent() {
        Pane root = new BorderPane();
        root.setPrefSize(1000,800 );
        root.getChildren().addAll(tileGroup, pieceGroup);



        Pieces piece = new Pieces(7);
        for(int i = 0; i < piece.shape.size(); i++){
            pieceGroup.getChildren().add(piece);
        }




        for(int y=0; y<PLAYABLE_HEIGHT; y++){
            for(int x = 0; x< PLAYABLE_WIDTH; x++){
                EmptyCases tile = new EmptyCases(x, y);

                tileGroup.getChildren().add(tile);
            }
        }

        return root;
    }

    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(createContent());
        stage.setTitle("Jeu - Niveau 12");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
