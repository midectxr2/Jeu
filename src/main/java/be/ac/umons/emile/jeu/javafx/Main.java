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
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;



public class Main extends Application {
    public static final int TILE_SIZE = 50;

    private Parent createContent() {
        Board board=new Board();
        BorderPane root = new BorderPane();
        root=board.createContent();
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
