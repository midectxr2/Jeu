package be.ac.umons.emile.jeu.javafx;

import be.ac.umons.emile.jeu.logique.*;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AppMenu extends Application {

    GameMenu gamemenu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Pane root = new Pane();
        root.setPrefSize(1900, 1000);
        gamemenu = new GameMenu();
        gamemenu.setVisible(true);


        InputStream is = Files.newInputStream(Paths.get("res/image/background.png"));
        Image img = new Image(is);
        is.close();
        ImageView imgV = new ImageView(img);
        imgV.setFitHeight(1400);
        imgV.setFitWidth(2000);

        root.getChildren().addAll(imgV, gamemenu);
        Scene scene = new Scene(root);
        stage.setTitle("Jeu");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
    }

    public class GameMenu extends Parent {

        GameMenu() {
            Pane root = new Pane();

            //on crée les conteneurs pour les boutons
            VBox menu = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);
            VBox menu3 = new VBox(10);
            VBox menu4 = new VBox(10);

            //transition
            final int offsett = 400;
            menu1.setTranslateX(offsett);

            Button play = new Button("Play");

            menu.setTranslateX(775);
            menu.setTranslateY(400);
            menu1.setTranslateY(100);
            menu2.setTranslateY(100);
            menu3.setTranslateY(100);
            menu4.setTranslateY(100);

            //bouton qui va ouvrir le menu avec les niveaux sauvegardés
            Button load = new Button("Load");
            load.setOnMouseClicked(event -> {
                getChildren().add(menu3);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu);
                tt.setToX(menu.getTranslateX() - offsett);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu3);
                tt1.setToX(menu.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(event1 -> {
                    getChildren().remove(menu);
                });
            });

            //bouton pour fermer le programme
            Button exit = new Button("Exit");
            exit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            //bouton level pour ouvrir un menu avec les boutons level pour changer de niveau sans revenir au menu principal
            play.setOnMouseClicked(event -> {
                getChildren().add(menu1);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu);
                tt.setToX(menu.getTranslateX() - offsett);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(event1 -> {
                    getChildren().remove(menu);
                });
            });

            //boutton qui permet de revenir au menu précédent
            Button back = new Button("BACK");
            back.setOnMouseClicked(event -> {
                getChildren().add(menu);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() + offsett);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(event1 -> {
                    getChildren().remove(menu1);
                });
            });

            back.setTranslateX(-700);

            //bouton qui permet de montrer les boutons des niveaux suivants
            Button next = new Button("Next");
            next.setOnMouseClicked(event -> {
                getChildren().add(menu2);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() + offsett);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(event1 -> {
                    getChildren().remove(menu1);
                });
            });

            //bouton qui permet de montrer les boutons des niveaux précédents
            Button previous = new Button("Previous");
            previous.setOnMouseClicked(event -> {
                getChildren().add(menu1);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
                tt.setToX(menu2.getTranslateX() + offsett);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu2.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(event1 -> {
                    getChildren().remove(menu2);
                });
            });

            //boutton qui permet de revenir au menu précédent
            Button back1 = new Button("BACK");
            back1.setOnMouseClicked(event -> {
                getChildren().add(menu);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu3);
                tt.setToX(menu3.getTranslateX() + offsett);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu);
                tt1.setToX(menu3.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(event1 -> {
                    getChildren().remove(menu3);
                });
            });

            back1.setTranslateX(-700);

            //bouton qui permet de montrer les boutons des niveaux suivants
            Button next1 = new Button("Next");
            next1.setOnMouseClicked(event -> {
                getChildren().add(menu4);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu3);
                tt.setToX(menu3.getTranslateX() + offsett);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu4);
                tt1.setToX(menu3.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(event1 -> {
                    getChildren().remove(menu3);
                });
            });

            //bouton qui permet de montrer les boutons des niveaux précédents
            Button previous1 = new Button("Previous");
            previous1.setOnMouseClicked(event -> {
                getChildren().add(menu3);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu4);
                tt.setToX(menu4.getTranslateX() + offsett);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu3);
                tt1.setToX(menu4.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(event1 -> {
                    getChildren().remove(menu4);
                });
            });

            //creation de tous les boutons levels
            VBox level = new VBox(10);
            VBox level1 = new VBox(10);

            for(int i = 1; i <= 10; i++){
                Button button = createLevel(i);
                level.getChildren().add(button);
            }
            for(int i = 11; i <= 20; i++){
                Button button = createLevel(i);
                level1.getChildren().add(button);
            }

            VBox level2 = new VBox(10);
            VBox level3 = new VBox(10);

            for(int i = 1; i <= 10; i++){
                Button button = createLevelSave(i);
                level2.getChildren().add(button);
            }
            for(int i = 11; i <= 20; i++){
                Button button = createLevelSave(i);
                level3.getChildren().add(button);
            }


            menu.getChildren().addAll(play, load, exit);
            menu1.getChildren().addAll(back, level, next);
            menu2.getChildren().addAll(previous, level1);
            menu3.getChildren().addAll(back1, level2, next1);
            menu4.getChildren().addAll(previous1, level3);

            getChildren().addAll(menu);
        }
    }

    //fonction qui permet de créer les boutons level
    private Button createLevel(int level){
        Button button = new Button("Level" + level);
        button.setOnMouseClicked(event -> {
            Level javafxApp = new Level("res/level/level" + level + ".txt");
            try {
                javafxApp.init();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                javafxApp.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.hide();
        });
        return button;
    }

    //fonction qui a pour but de définir la forme et les caractéristique des boutons
    public static class Button extends StackPane {
        Button(String name){
            Text text = new Text(name);
            text.setFont(Font.font(50));
            text.setFill(Color.BLACK);

            Rectangle rt = new Rectangle(400, 60);
            rt.setFill(Color.GREY);
            setAlignment(Pos.CENTER);
            getChildren().addAll(rt, text);

            setOnMouseEntered(event -> {
                rt.setFill(Color.WHITE);
                text.setFill(Color.GREY);
            });
            setOnMouseExited(event -> {
                rt.setFill(Color.GREY);
                text.setFill(Color.BLACK);
            });
        }
    }

    private Button createLevelSave(int level){
        Button button = new Button("Level " + level + " save");
        button.setOnMouseClicked(event -> {
            Level javafxApp = new Level("res/level/level" + level + "_save.txt");
            try {
                javafxApp.init();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                javafxApp.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.hide();
        });
        return button;
    }
}
