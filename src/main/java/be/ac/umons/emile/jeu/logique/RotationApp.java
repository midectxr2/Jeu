package be.ac.umons.emile.jeu.logique;
import be.ac.umons.emile.jeu.javafx.Main;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;




public class RotationApp extends Rectangle{

    private Pieces piece;
    private Group groupPiece;
    public RotationApp(Group groupPiece, Pieces piece){
        for(int i=0;i<piece.shape.size();i++){
            groupPiece.getChildren().add(piece.shape.get(i));
        }
        this.piece=piece;
        this.groupPiece=groupPiece;

    }
    /*public void rotate(){
        double xc=getCenterX();
        double yc=getCenterY();

        for(PlayableCases c:piece.shape){
            c.setX(xc-(c.getY()-yc));
            c.setY(yc+(c.getX()-xc));


        }

    }*/

    public void Rotation(Node pieces){
        pieces=groupPiece;
        double xc=getCenterX();
        double yc=getCenterY();
        pieces.setOnMouseClicked(new EventHandler<MouseEvent>() {//Permet de Rotate avec juste un clic droit
            @Override
            public void handle(MouseEvent event) {
                MouseButton button=event.getButton();
                if(button==MouseButton.SECONDARY){
                    piece.rota=(piece.rota +90)%360;
                    groupPiece.setRotate(piece.rota);
                    for(PlayableCases c:piece.shape){
                        c.setPX(xc-(c.getPY()-yc));
                        c.setPY(yc+(c.getPX()-xc));
                        System.out.println(c.getPX() + " " +c.getPY());
                        relocate(c.getPX() * Main.TILE_SIZE, c.getPY()*Main.TILE_SIZE);
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
            if(c.getPX()>max){
                max=c.getPX();
            }
        }
        return max;
    }

    public double minX(){
        double min;
        min=piece.shape.get(0).getPX();
        for(PlayableCases c:piece.shape){
            if(c.getPX()>min){
                min=c.getPX();
            }
        }
        return min;
    }
    public double maxY(){
        double max=0;
        for(PlayableCases c:piece.shape){
            if(c.getPY()>max){
                max=c.getPY();
            }
        }
        return max;
    }

    public double minY(){
        double min;
        min=piece.shape.get(0).getPY();
        for(PlayableCases c:piece.shape){
            if(c.getPY()>min){
                min=c.getPY();
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
