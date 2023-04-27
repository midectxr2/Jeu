package be.ac.umons.emile.jeu.javafx;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static javafx.application.Application.launch;

public class InGameMenu extends Application {
    GameMenu gamemenu;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        root.setPrefSize(900, 700);
        gamemenu = new GameMenu();
        gamemenu.setVisible(false);


        InputStream is = Files.newInputStream(Paths.get("res/Image/background.png"));
        Image img = new Image(is);
        is.close();
        ImageView imgV = new ImageView(img);
        imgV.setFitHeight(700);
        imgV.setFitWidth(900);


        root.getChildren().addAll(imgV, gamemenu);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ESCAPE) {
                if (!gamemenu.isVisible()) {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gamemenu);
                    ft.setFromValue(0);
                    ft.setToValue(1);

                    gamemenu.setVisible(true);
                    ft.play();
                }
                else {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gamemenu);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(event1 -> {
                        gamemenu.setVisible(false);
                    });
                    ft.play();

                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    private class GameMenu extends Parent {
        public GameMenu() {

            VBox menu = new VBox(10);
            VBox menu1 = new VBox(10);

            menu.setTranslateX(100);
            menu.setTranslateY(200);
            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

            final int offsett = 400;
            menu1.setTranslateX(offsett);

            Button resume = new Button("RESUME");
            resume.setOnMouseClicked(event -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(event1 -> setVisible(false));
                ft.play();
            });


            Button exit = new Button("EXIT");
            exit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            Button levels = new Button("LEVELS");
            levels.setOnMouseClicked(event -> {
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



            //boutton qui permet de revenir au menu précédent en changeant la position en X
            //du menu en question qui se décale
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

            Button level11 = new Button("LEVEL11");
            Button level12 = new Button("LEVEL12");
            Button level13 = new Button("LEVEL13");
            Button level14 = new Button("LEVEL14");






            menu.getChildren().addAll(resume, exit, levels);
            menu1.getChildren().addAll(back, level11, level12, level13, level14);

            Rectangle rt = new Rectangle(900, 700);
            rt.setFill(Color.GRAY);
            rt.setOpacity(0.4);


            getChildren().addAll(rt, menu);
        }
    }

    public static class Button extends StackPane {
        public Button(String name) {
            Text text = new Text(name);
            text.setFont(Font.font(20));
            text.setFill(Color.WHITE);


            Rectangle rt = new Rectangle(250, 30);
            rt.setFill(Color.BLACK);
            setAlignment(Pos.CENTER);
            getChildren().addAll(rt, text);

            setOnMouseEntered(event -> {
                rt.setTranslateX(10);
                text.setTranslateX(10);
                rt.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                rt.setTranslateX(0);
                text.setTranslateX(0);
                rt.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));

        }
    }
}
