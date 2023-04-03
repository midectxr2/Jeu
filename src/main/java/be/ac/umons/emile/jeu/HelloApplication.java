package be.ac.umons.emile.jeu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;


import static javafx.application.Application.launch;

public class HelloApplication extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("My_First_JavaFX_App");

        BorderPane root = new BorderPane();
        Text helloText = new Text("Hello World");
        root.setCenter(helloText);
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}