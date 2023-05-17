package be.ac.umons.emile.jeu.logique;
import be.ac.umons.emile.jeu.javafx.AppMenu;
import be.ac.umons.emile.jeu.javafx.InGameMenu;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level extends Application{

    public int height;
    public int width;
    String fileName;
    private int x = 1;
    public double[][] board;
    FlowPane piecePane=new FlowPane();
    private DraggableApp drag = new DraggableApp();
    private RotationApp rota;
    private int gridHeight;
    private int gridWidth;
    public ArrayList<Pieces> pieces = new ArrayList<>();
    public ArrayList<char[]> pos = new ArrayList<>();
    GameMenu gamemenu;
    private ArrayList<PlayableCases> shape=new ArrayList<>();

    public Level(String path)  {
        this.fileName=path;
        int readLine=0;
        try {

            // Le fichier d'entrée
            File file = new File(this.fileName);
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                char[] tab = new char[line.length()];
                // ajoute la ligne au buffer
                tab = line.toCharArray();
                pos.add(tab);
            }
            fr.close();
            height = pos.get(0)[1] - '0';//tableau de 9x9 max faire split "-" si plus grand;
            width = pos.get(0)[0] - '0';
            board = new double[height][width];
            for (int i = 1; i < height + 1; i++) {
                for (int j = 0; j < width; j++) {
                    board[i - 1][j] = pos.get(i)[j] - '0';
                }
                readLine=i;
            }
            gridWidth=width;
            gridHeight=height;
            while(readLine<pos.size()-1){
                readLine++;
                shape.clear();
                height=pos.get(readLine)[1]-'0';
                width=pos.get(readLine)[0]-'0';
                for(int i=0; i<height;i++){
                    readLine++;
                    for(int j=0;j<width;j++){
                        if(pos.get(readLine)[j]=='1') {
                            shape.add(new PlayableCases(j,i));
                        }
                    }
                }
                pieces.add(new Pieces(shape));

            }
        } catch (IOException e) {
            System.out.print("Gros con");

        }

    }

    public boolean hasValue(double[][] board) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkCase(int x, int y, Pieces piece) {
        for (int i = 0; i < piece.shape.size(); i++) {
            if (board[x + (int)piece.shape.get(i).getPX()][y + (int)piece.shape.get(i).getPY()] != 1) {
                return false;
            }
        }
        return true;
    }

    public Pane createContent() {
        Level jeu=new Level(fileName);
        Pane root = new Pane();
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        piecePane.setHgap(10);
        piecePane.setVgap(5);
        root.getChildren().add(grid);
        gamemenu = new GameMenu();
        gamemenu.setVisible(false);

        for (int i = 0; i < jeu.gridHeight; i++) {
            RowConstraints row = new RowConstraints(50);
            grid.getRowConstraints().add(row);
        }
        for (int i = 0; i < jeu.gridWidth; i++) {
            ColumnConstraints col = new ColumnConstraints(50);
            grid.getColumnConstraints().add(col);
        }


        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (jeu.board[i][j] == 0) {
                    EmptyCases tile = new EmptyCases(j, i);
                    grid.add(tile, j, i);

                }
            }
        }

        for (Pieces c : jeu.pieces) {
            rota = new RotationApp(c);
            drag.makeDraggable(c,grid,root);
            rota.Rotation(c);;
            root.getChildren().add(c);

        }


        root.getChildren().add(gamemenu);
        return root;
    }
    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(createContent());
        stage.setTitle("Jeu");
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.SPACE) {
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
        stage.setFullScreen(true);
    }

    private class GameMenu extends Parent {
        public GameMenu() {

            VBox menu = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);

            menu.setTranslateX(100);
            menu.setTranslateY(200);
            menu1.setTranslateX(50);
            menu1.setTranslateY(200);
            menu2.setTranslateX(50);
            menu2.setTranslateY(200);

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
                AppMenu javafxApp = new AppMenu();
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


            menu.getChildren().addAll(resume, levels, exit);
            menu1.getChildren().addAll(back, level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, next);
            menu2.getChildren().addAll(previous, level11, level12, level13, level14, level15, level16, level17, level18, level19, level20);

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


    public static void main(String[] args){
        Application.launch(args);
    }


}

