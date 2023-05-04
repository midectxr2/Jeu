package be.ac.umons.emile.jeu.logique;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.Group;



public class RotationApp{

    private Pieces piece;
    private Group groupPiece;
    public RotationApp(Group groupPiece, Pieces piece){
        for(int i=0;i<piece.shape.size();i++){
            groupPiece.getChildren().add(piece.shape.get(i));
        }
        this.piece=piece;
        this.groupPiece=groupPiece;

    }
    public void rotate(){
        double xc=getCenterX();
        double yc=getCenterY();

        for(PlayableCases c:piece.shape){
            c.setX(xc-(c.getY()-yc));
            c.setY(yc+(c.getX()-xc));
        }

    }

    public void Rotation(Node pieces){
        pieces=groupPiece;
        pieces.setOnMouseClicked(new EventHandler<MouseEvent>() {//Permet de Rotate avec juste un clic droit

            @Override
            public void handle(MouseEvent event) {
                MouseButton button=event.getButton();
                if(button==MouseButton.SECONDARY){
                    double xc=getCenterX();
                    double yc=getCenterY();

                    for(PlayableCases c:piece.shape){
                        c.setX(xc-(c.getY()-yc));
                        c.setY(yc+(c.getX()-xc));
                    }
                }
            }
        });
    }

    public void addPiece(Pieces piece){
        for(int i=0;i<piece.shape.size();i++){
            groupPiece.getChildren().add(piece.shape.get(i));
        }
    }


    public double maxX(){
        double max=0;
        for(PlayableCases c:piece.shape){
            if(c.getX()>max){
                max=c.getX();
            }
        }
        return max;
    }

    public double minX(){
        double min;
        min=piece.shape.get(0).getX();
        for(PlayableCases c:piece.shape){
            if(c.getX()>min){
                min=c.getX();
            }
        }
        return min;
    }
    public double maxY(){
        double max=0;
        for(PlayableCases c:piece.shape){
            if(c.getY()>max){
                max=c.getY();
            }
        }
        return max;
    }

    public double minY(){
        double min;
        min=piece.shape.get(0).getY();
        for(PlayableCases c:piece.shape){
            if(c.getY()>min){
                min=c.getX();
            }
        }
        return min;
    }
    public double getCenterX(){
        return (minX()+maxX())/2;
    }

    public double getCenterY(){
        return (minY()+maxY())/2;
    }

}
