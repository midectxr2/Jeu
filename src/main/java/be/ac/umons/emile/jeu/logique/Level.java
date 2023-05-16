package be.ac.umons.emile.jeu.logique;
import be.ac.umons.emile.jeu.javafx.InGameMenu;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
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

            menu.setTranslateX(100);
            menu.setTranslateY(200);
            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

            final int offsett = 400;
            menu1.setTranslateX(offsett);

            InGameMenu.Button resume = new InGameMenu.Button("RESUME");
            resume.setOnMouseClicked(event -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(event1 -> setVisible(false));
                ft.play();
            });


            InGameMenu.Button exit = new InGameMenu.Button("EXIT");
            exit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            InGameMenu.Button levels = new InGameMenu.Button("LEVELS");
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
            InGameMenu.Button back = new InGameMenu.Button("BACK");
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

            InGameMenu.Button level11 = new InGameMenu.Button("LEVEL11");
            InGameMenu.Button level12 = new InGameMenu.Button("LEVEL12");
            InGameMenu.Button level13 = new InGameMenu.Button("LEVEL13");
            InGameMenu.Button level14 = new InGameMenu.Button("LEVEL14");

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


    public static void main(String[] args){
        Application.launch(args);
    }


}

