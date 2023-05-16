package be.ac.umons.emile.jeu.logique;
import be.ac.umons.emile.jeu.javafx.AppMenu;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    private MenuWindow menuWindow;

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



        return root;
    }
    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(createContent());
        stage.setTitle("Jeu");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);

        menuWindow = new MenuWindow();

        scene.setOnKeyPressed(event -> {
            try {
                MenuWindow.open();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args){
        Application.launch(args);
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

    public class MenuWindow extends Parent {
        public static void open() throws Exception{
            Stage window = new Stage();
            window.setTitle("Menu");

            InputStream is = Files.newInputStream(Paths.get("res/Image/background.png"));
            Image img = new Image(is);
            is.close();
            ImageView imgV = new ImageView(img);
            imgV.setFitHeight(2000);
            imgV.setFitWidth(2200);


            Button resume = new Button("Resume");
            Button option = new Button("Option");
            Button exit = new Button("Exit");

            resume.setOnMouseClicked(event -> {
                window.close();
            });

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

            VBox Menu = new VBox(10);
            Menu.getChildren().addAll(resume, option, exit);

            Scene menuInGame = new Scene(Menu, 700, 800);
            window.setScene(menuInGame);
            window.show();
            window.setFullScreen(true);
        }
    }
}

