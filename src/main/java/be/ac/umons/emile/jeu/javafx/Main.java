package be.ac.umons.emile.jeu.javafx;

import be.ac.umons.emile.jeu.logique.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
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
        BorderPane root = new BorderPane();


        root.setCenter(tileGroup);
        root.setRight(pieceGroup);
        BorderPane.setAlignment(pieceGroup, Pos .CENTER);
        BorderPane.setAlignment(tileGroup, Pos .CENTER);



        Pieces piece = new Pieces();

        for(int i=0;i<piece.shape.size();i++){
            pieceGroup.getChildren().add(piece.shape.get(i));
        }



        for(int y=0; y<PLAYABLE_HEIGHT; y++){
            for(int x = 0; x< PLAYABLE_WIDTH; x++){
                EmptyCases tile = new EmptyCases(x, y);

                tileGroup.getChildren().add(tile);
            }
        }

        root.getChildren().forEach(p -> makeDraggable(p));

        return root;
    }

    public double startX;
    public double startY;
    public void makeDraggable(Pieces piece2){
        piece2.setOnMousePressed(event -> {
            startX = event.getSceneX() - piece2.getTranslateX();
            startY = event.getSceneY() - piece2.getTranslateY();
        });

        piece2.setOnMouseDragged(event -> {
            piece2.setTranslateX(event.getSceneX() - startX);
            piece2.setTranslateY(event.getSceneY() - startY);
        });
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
