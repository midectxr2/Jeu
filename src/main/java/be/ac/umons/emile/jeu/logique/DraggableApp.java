package be.ac.umons.emile.jeu.logique;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;

public class DraggableApp {
    public double startX;
    public double startY;
    public void makeDraggable(Pieces piece2,GridPane grid,Pane root){
        piece2.setOnMousePressed(new EventHandler<MouseEvent>() {//Permet de drag en maintenant seulement le clic gauche
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if (button == MouseButton.PRIMARY) {
                    startX = event.getSceneX() - piece2.getTranslateX();
                    startY = event.getSceneY() - piece2.getTranslateY();
                }
            }
        });


        piece2.setOnMouseDragged(new EventHandler<MouseEvent>() {//Permet de drag en maintenant seulement le clic gauche
            @Override
            public void handle(MouseEvent event) {
                MouseButton button=event.getButton();
                if(button== MouseButton.PRIMARY){
                    piece2.setTranslateX(event.getSceneX() - startX);
                    piece2.setTranslateY(event.getSceneY() - startY);

                }
            }

        });
        piece2.setOnMouseReleased(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                MouseButton button=event.getButton();
                if(button==MouseButton.PRIMARY) {
                    double cellWidth = grid.getWidth() / grid.getColumnCount();
                    double cellHeight = grid.getHeight() / grid.getRowCount();
                    double pieceCenterX = piece2.getBoundsInLocal().getMaxX() - piece2.getBoundsInLocal().getMinX() / 2;
                    double pieceCenterY = piece2.getBoundsInLocal().getMaxY() - piece2.getBoundsInLocal().getMinY() / 2;

                    int pieceColumn = (int) Math.round((pieceCenterX - event.getSceneX()) / cellWidth);
                    int pieceRow = (int) Math.round((pieceCenterY - event.getSceneY()) / cellHeight);
                    double nearestCellX = grid.getBoundsInLocal().getMinX() + pieceColumn * cellWidth;
                    double nearestCellY = grid.getBoundsInLocal().getMinY() + pieceRow * cellHeight;

                    piece2.setLayoutX(nearestCellX - piece2.getBoundsInLocal().getMaxX() / 2);
                    piece2.setLayoutY(nearestCellY - piece2.getBoundsInLocal().getMaxY() / 2);
                }
            }
        });

    }
}
