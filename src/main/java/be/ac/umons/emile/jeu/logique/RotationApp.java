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

    public RotationApp(Pieces piece){
        this.piece=piece;
    }

    public void Rotation(Node pieces){
        int xc=getCenterX();
        int yc=getCenterY();
        pieces.setOnMouseClicked(new EventHandler<MouseEvent>() {//Permet de Rotate avec juste un clic droit
            @Override
            public void handle(MouseEvent event) {
                MouseButton button=event.getButton();
                if(button==MouseButton.SECONDARY){
                    piece.rota=(piece.rota +90)%360;
                    piece.setRotate(piece.rota);

                    for(PlayableCases c:piece.shape){

                        System.out.println(c.getPX() + " " + c.getPY()+ " "+ xc+" "+yc);
                        int x=xc-(c.getPY()-yc);
                        int y=yc+(c.getPX()-xc);
                        c.setPX(x);
                        c.setPY(y);

                        System.out.println(c.getPX() + " " + c.getPY());
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


    public int maxX(){
        int max=0;
        for(PlayableCases c:piece.shape){
            if(c.getPX()>max){
                max=c.getPX();
            }
        }
        return max;
    }

    public int minX(){
        int min;
        min=piece.shape.get(0).getPX();
        for(PlayableCases c:piece.shape){
            if(c.getPX()<min){
                min=c.getPX();
            }
        }
        return min;
    }
    public int maxY(){
        int max=0;
        for(PlayableCases c:piece.shape){
            if(c.getPY()>max){
                max=c.getPY();
            }
        }
        return max;
    }

    public int minY(){
       int min;
        min=piece.shape.get(0).getPY();
        for(PlayableCases c:piece.shape){
            if(c.getPY()<min){
                min=c.getPY();
            }
        }
        return min;

    }
    public int getCenterX(){
        return (minX()+maxX())/2;
    }

    public int getCenterY(){
        return (minY()+maxY())/2;
    }

}
