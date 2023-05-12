package be.ac.umons.emile.jeu.javafx;

import be.ac.umons.emile.jeu.logique.*;
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

            Rectangle rt = new Rectangle(1900, 1000);
            rt.setFill(Color.BLACK);

            VBox menu = new VBox(10);
            Button play = new Button("Play");

            menu.setTranslateX(775);
            menu.setTranslateY(400);

            Button option = new Button("Option");

            option.setOnMouseClicked(event -> {

            });

            Button exit = new Button("Exit");

            exit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            play.setOnMouseClicked(event -> {
                Button level1 = new Button("level 1");
                Button level2 = new Button("level 2");
                Button level3 = new Button("level 3");
                Button level4 = new Button("level 4");
                Button level5 = new Button("level 5");
                Button level6 = new Button("level 6");
                Button level7 = new Button("level 7");
                Button level8 = new Button("level 8");
                Button level9 = new Button("level 9");
                Button level10 = new Button("level 10");
                Button next = new Button("Next");
                Button level11 = new Button("level 11");
                Button level12 = new Button("level 12");
                Button level13 = new Button("level 13");
                Button level14 = new Button("level 14");
                Button level15 = new Button("level 15");
                Button level16 = new Button("level 16");
                Button level17 = new Button("level 17");
                Button level18 = new Button("level 18");
                Button level19 = new Button("level 19");
                Button level20 = new Button("level 20");
                Button back = new Button("Back");
                Button previous = new Button("previous");

                menu.getChildren().removeAll(play, exit, option);
                menu.getChildren().addAll(back, level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, next);
                menu.setTranslateY(20);
                back.setTranslateX(-750);

                back.setOnMouseClicked(event1 -> {
                    menu.getChildren().removeAll(back, level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, next);
                    menu.getChildren().addAll(play, option, exit);
                    menu.setTranslateY(400);
                });

                next.setOnMouseClicked(event1 -> {
                    menu.getChildren().removeAll(level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, next);
                    menu.getChildren().addAll(previous, level11, level12, level13, level14, level15, level16, level17, level18, level19, level20);
                    previous.setOnMouseClicked(event2 -> {
                        menu.getChildren().removeAll(previous, level11, level12, level13, level14, level15, level16, level17, level18, level19, level20);
                        menu.getChildren().addAll(level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, next);
                    });
                });

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
            });

            menu.getChildren().addAll(play, option, exit);
            root.getChildren().addAll(menu);
            getChildren().addAll(root);
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
