package be.ac.umons.emile.jeu.javafx;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Title extends Pane {
    private Text text;

    public Title(String name) {
        text = new Text(name);
        text.setFill(Color.WHITE);
        text.setEffect(new DropShadow(30, Color.BLACK));

        getChildren().addAll(text);

    }
    public double getTitleWidth() { return text.getLayoutBounds().getWidth();}

    public double getTitleHeight() { return text.getLayoutBounds().getHeight();}
}
