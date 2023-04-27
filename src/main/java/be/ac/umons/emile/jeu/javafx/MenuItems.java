package be.ac.umons.emile.jeu.javafx;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

public class MenuItems extends Pane {
    private Text text;

    private Effect shadow = new DropShadow(5, Color.BLACK);
    private Effect blur = new BoxBlur(1, 1, 3);

    public MenuItems(String name){
        Polygon bg = new Polygon(
                0, 0,
                200, 0,
                215, 15,
                200, 30,
                0, 30
        );
        bg.setStroke(Color.color(1, 1, 1, 0.75));
        bg.setEffect(new GaussianBlur());


        text = new Text(name);
        text.setTranslateX(5);
        text.setTranslateY(20);
        text.setFill(Color.WHITE);



        getChildren().addAll(bg, text);
    }

    public void setOnAction(Runnable action) {setOnMouseClicked(event -> action.run());}

}
