package be.ac.umons.emile.jeu.javafx;

import be.ac.umons.emile.jeu.logique.Levels.Level1;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Main extends Application {
    public static final int TILE_SIZE = 50;

    private Parent createContent() {
        BorderPane root = new BorderPane();
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
