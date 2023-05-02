package be.ac.umons.emile.jeu.logique;

import javafx.application.Application;
import javafx.scene.Node;

public class DraggableApp {
    public double startX;
    public double startY;
    public void makeDraggable(Node piece2){
        piece2.setOnMousePressed(event -> {
            startX = event.getSceneX() - piece2.getTranslateX();
            startY = event.getSceneY() - piece2.getTranslateY();
        });

        piece2.setOnMouseDragged(event -> {
            piece2.setTranslateX(event.getSceneX() - startX);
            piece2.setTranslateY(event.getSceneY() - startY);
        });
    }
}
