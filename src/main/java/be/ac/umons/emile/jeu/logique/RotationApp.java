package be.ac.umons.emile.jeu.logique;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;



public class RotationApp{

    public void Rotation(Node piece){
        piece.setOnMouseClicked(new EventHandler<MouseEvent>() {//Permet de Rotate avec juste un clic droit

            @Override
            public void handle(MouseEvent event) {
                MouseButton button=event.getButton();
                if(button==MouseButton.SECONDARY){
                    piece.setRotate(90);

                }
            }
        });
    }

}
