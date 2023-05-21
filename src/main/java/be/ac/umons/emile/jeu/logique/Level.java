package be.ac.umons.emile.jeu.logique;
import be.ac.umons.emile.jeu.javafx.AppMenu;
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

import java.io.*;

import java.util.ArrayList;

public class Level extends Application{

    private double x;
    private double y;
    public int height;
    public int width;
    String fileName;
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
            File file = new File(this.fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                char[] tab;
                tab = line.toCharArray();
                pos.add(tab);
            }
            fr.close();
            height = pos.get(0)[1] - '0';
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
            e.printStackTrace();

        }

    }

    public boolean hasValue() {

        for(Pieces pieces1 : pieces) {
            double startRow = pieces1.minY();
            double endRow = pieces1.maxY();
            double startCol = pieces1.minX();
            double endCol = pieces1.maxX();
            //on regarde si les pièces sont bien à l'intérieur de la grille
            if (startRow < 0 || endRow >= gridHeight || startCol < 0 || endCol >= gridWidth) {
                return false;
            }
        }

        //on regarde si toutes les cases de la grille sont chevauchées par les pièces
        for (int i = 0; i <= gridWidth; i++) {
            for (int j = 0; j <= gridHeight; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i <= gridWidth; i++) {
            for (int j = 0; j <= gridHeight; j++) {
                if (board[i][j] == 1) {
                    return true;
                }
            }
        }

        return true;
    }


    public boolean checkCase(int x, int y, Pieces piece) {
        for (int i = 0; i < piece.shape.size(); i++) {
            if (board[x + (int)piece.shape.get(i).getPX()][y + (int)piece.shape.get(i).getPY()] != 1) {
                return false;
            }
        }
        return true;
    }

    public void save(String path){
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter(path));
            for(Pieces c: pieces){
                String x=""+c.getBoundsInParent();
                String y=""+ c.getLayoutY();
                String rota="" + c.rota;

                String position= x+"-"+y+"-"+rota;
                writer.write(position);
                writer.newLine();
                writer.close();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void load(String path){
        ArrayList<Pieces> piecePosition=new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String tab;
                tab = line;
                String[] words=tab.split("-");
                for(Pieces c:pieces){
                    c.setLayoutX(Integer.parseInt(words[0]));
                    c.setLayoutY(Integer.parseInt(words[1]));
                    c.setRotate(Integer.parseInt(words[2]));
                }
            }
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private void display(Pieces piece,BorderPane root){
        piecePane.setHgap(10);
        piecePane.setVgap(5);
        piecePane.getChildren().add(piece);
        root.setRight(piecePane);
    }

    public Pane createContent() {
        Level jeu=new Level(fileName);
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        root.setCenter(grid);
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
            rota.Rotation(c);
            display(c,root);
        }

        Button finish = new Button("Finish");
        finish.setVisible(false);
        finish.setTranslateX(1600);
        finish.setTranslateY(1000);
        if(hasValue() == true){
            finish.setVisible(true);
        }

        finish.setOnMouseClicked(event -> {
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

        root.getChildren().addAll(gamemenu, finish);
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

            //on crée les conteneurs pour les boutons
            VBox menu = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);

            //on place les conteneurs pour qu'il soit au centre
            menu.setTranslateX(835);
            menu.setTranslateY(200);
            menu1.setTranslateX(835);
            menu1.setTranslateY(200);
            menu2.setTranslateX(835);
            menu2.setTranslateY(200);

            final int offsett = 400;
            menu1.setTranslateX(offsett);

            //bouton resume pour fermer le menu
            Button resume = new Button("RESUME");
            resume.setOnMouseClicked(event -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(event1 -> setVisible(false));
                ft.play();
            });

            //bouton exit pour quitter le niveau et revenir au menu principale
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

            //bouton level pour ouvrir un menu avec les boutons level pour changer de niveau sans revenir au menu principal
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

            //bouton qui permet de sauvegarder le niveau(position des pièces)
            Button save = new Button("Save");
            save.setOnMouseClicked(event -> {
                String[] saved = fileName.split(".txt");
                save(saved[0] + "_save.txt");

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


            menu.getChildren().addAll(resume, levels,save, exit);
            menu1.getChildren().addAll(back, level, next);
            menu2.getChildren().addAll(previous, level1);

            Rectangle rt = new Rectangle(2000, 1700);
            rt.setFill(Color.GRAY);
            rt.setOpacity(0.4);


            getChildren().addAll(rt, menu);
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

