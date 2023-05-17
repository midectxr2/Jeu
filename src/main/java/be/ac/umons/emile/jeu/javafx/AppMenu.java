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
        GameMenu(){
            Pane root = new Pane();

            VBox menu = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);

            final int offsett = 400;
            menu1.setTranslateX(offsett);

            Button play = new Button("Play");

            menu.setTranslateX(775);
            menu.setTranslateY(400);
            menu1.setTranslateY(100);
            menu2.setTranslateY(100);

            Button option = new Button("Option");

            option.setOnMouseClicked(event -> {

            });

            Button exit = new Button("Exit");

            exit.setOnMouseClicked(event -> {
                System.exit(0);
            });

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

            Button level1 = new Button("LEVEL 1");
            Button level2 = new Button("LEVEL 2");
            Button level3 = new Button("LEVEL 3");
            Button level4 = new Button("LEVEL 4");
            Button level5 = new Button("LEVEL 5");
            Button level6 = new Button("LEVEL 6");
            Button level7 = new Button("LEVEL 7");
            Button level8 = new Button("LEVEL 8");
            Button level9 = new Button("LEVEL 9");
            Button level10 = new Button("LEVEL 10");
            Button level11 = new Button("LEVEL 11");
            Button level12 = new Button("LEVEL 12");
            Button level13 = new Button("LEVEL 13");
            Button level14 = new Button("LEVEL 14");
            Button level15 = new Button("LEVEL 15");
            Button level16 = new Button("LEVEL 16");
            Button level17 = new Button("LEVEL 17");
            Button level18 = new Button("LEVEL 18");
            Button level19 = new Button("LEVEL 19");
            Button level20 = new Button("LEVEL 20");

            level1.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level11.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level2.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level12.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });


            level3.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level13.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level4.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level14.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level5.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level15.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level6.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level16.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level7.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level17.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level8.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level18.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level9.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level19.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level10.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level20.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level11.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level21.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level12.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level22.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level13.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level23.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level14.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level24.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level15.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level25.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level16.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level26.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level17.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level27.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level18.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level28.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level19.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level29.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            level20.setOnMouseClicked(event1 -> {
                Level javafxApp = new Level("res/level/level30.txt");
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
                Node source = (Node) event1.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();

            });

            menu.getChildren().addAll(play, option, exit);
            menu1.getChildren().addAll(back, level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, next);
            menu2.getChildren().addAll(previous, level11, level12, level13, level14, level15, level16, level17, level18, level19, level20);

            getChildren().addAll(menu);
        }
    }

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
}
