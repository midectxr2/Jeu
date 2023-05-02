package be.ac.umons.emile.jeu.javafx;

import be.ac.umons.emile.jeu.logique.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

    public static final int TILE_SIZE = 50;
    public static final int PLAYABLE_WIDTH = 6;
    public static final int PLAYABLE_HEIGHT = 6;

    private DraggableApp drag=new DraggableApp();
    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();
    private Group pieceGroup2=new Group();


    private Parent createContent() {
        BorderPane root = new BorderPane();


        root.setCenter(tileGroup);
        root.setRight(pieceGroup);
        root.setLeft(pieceGroup2);
        BorderPane.setAlignment(pieceGroup, Pos .CENTER);
        BorderPane.setAlignment(tileGroup, Pos .CENTER);


        Rectangle r=new Rectangle();
        Pieces piece = new Pieces('a');
        Pieces piece2=new Pieces('b');

        for(int i=0;i<piece.shape.size();i++){
            pieceGroup.getChildren().add(piece.shape.get(i));
        }

        for(int i=0;i<piece2.shape.size();i++){
            pieceGroup2.getChildren().add(piece2.shape.get(i));
        }

        /*Pour faire en sorte que ça stick à la grille faudrait qu'on "invoque une board" comme ç c'est déjà
        un tout qu'on met dans un groupe puis faudrait faire une classe comme DraggableApp qui dit:
        Si au dessus de la grille
            *insérer la formule du boss d'elden ring*
        Je pense que c'est une piste,suppr le comm si ça pue
         */

        for(int y=0; y<PLAYABLE_HEIGHT; y++){
            for(int x = 0; x< PLAYABLE_WIDTH; x++){
                EmptyCases tile = new EmptyCases(x, y);

                tileGroup.getChildren().add(tile);
            }
        }
        drag.makeDraggable(pieceGroup2);
        drag.makeDraggable(pieceGroup);

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
