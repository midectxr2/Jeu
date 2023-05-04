package be.ac.umons.emile.jeu.javafx;

import be.ac.umons.emile.jeu.logique.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.events.Event;


public class Main extends Application {

    public static final int TILE_SIZE = 50;
    public static final int PLAYABLE_WIDTH = 6;
    public static final int PLAYABLE_HEIGHT = 6;

    private RotationApp rot;
    private RotationApp rot2;
    private DraggableApp drag=new DraggableApp();
    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();
    private Group pieceGroup2=new Group();


    private Parent createContent() {
        BorderPane root = new BorderPane();
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);

        root.setCenter(grid);



        Rectangle r=new Rectangle();
        Pieces piece = new Pieces('a');
        Pieces piece2=new Pieces('w');



        /*for(int i=0;i<piece.shape.size();i++){
            pieceGroup.getChildren().add(piece.shape.get(i));
        }

        for(int i=0;i<piece2.shape.size();i++){
            pieceGroup2.getChildren().add(piece2.shape.get(i));
        }*/

        /*Pour faire en sorte que ça stick à la grille faudrait qu'on "invoque une board" comme ç c'est déjà
        un tout qu'on met dans un groupe puis faudrait faire une classe comme DraggableApp qui dit:
        Si au dessus de la grille
            *insérer la formule du boss d'elden ring*
        Je pense que c'est une piste,suppr le comm si ça pue
         */

        for(int y=0; y<PLAYABLE_HEIGHT; y++){
            for(int x = 0; x< PLAYABLE_WIDTH; x++){
                EmptyCases tile = new EmptyCases(x, y);

               grid.add(tile,x,y);
            }
        }
        rot=new RotationApp(pieceGroup,piece);
        rot2=new RotationApp(pieceGroup2,piece2);
        rot.Rotation(pieceGroup);
        rot2.Rotation(pieceGroup2);
        drag.makeDraggable(pieceGroup);
        drag.makeDraggable(pieceGroup2);
        root.setRight(pieceGroup);
        root.setLeft(pieceGroup2);
        BorderPane.setAlignment(pieceGroup, Pos .CENTER);
        BorderPane.setAlignment(tileGroup, Pos .CENTER);
        return root;
    }


    public void handle(MouseEvent event) {
        MouseButton button = event.getButton();
        if(button==MouseButton.PRIMARY){
            drag.makeDraggable(pieceGroup2);
            drag.makeDraggable(pieceGroup);
        }else if(button==MouseButton.SECONDARY){
            rot.Rotation(pieceGroup);
            rot.Rotation(pieceGroup2);
        }




    }
    @Override
    public void start(Stage stage) throws Exception{
        System.out.println("toto");
        Scene scene = new Scene(createContent());
        stage.setTitle("Jeu - Niveau 12");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
