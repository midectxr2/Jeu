package be.ac.umons.emile.jeu.logique;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
public class Pieces extends Group {
    public int rota;

    public ArrayList<PlayableCases> shape=new ArrayList<>();
    public Pieces(ArrayList<PlayableCases> shape) {
        this.shape=shape;

        for(int i=0;i<shape.size();i++){
            getChildren().add(shape.get(i));
        }

    }

    public double maxX(){
        double max=0;
        for(PlayableCases c:shape){
            if(c.getPX()>max){
                max=c.getPX();
            }
        }
        return max;
    }

    public double minX(){
        double min;
        min=shape.get(0).getPX();
        for(PlayableCases c:shape){
            if(c.getPX()<min){
                min=c.getPX();
            }
        }
        return min;
    }
    public double maxY(){
        double max=0;
        for(PlayableCases c:shape){
            if(c.getPY()>max){
                max=c.getPY();
            }
        }
        return max;
    }

    public double minY(){
        double min;
        min=shape.get(0).getPY();
        for(PlayableCases c:shape){
            if(c.getPY()<min){
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

    public void rotate(){
        double xc=getCenterX();
        double yc=getCenterY();

        for(PlayableCases c:shape){
            c.setX(xc-(c.getPY()-yc));
            c.setY(yc+(c.getPX()-xc));
        }

    }



}