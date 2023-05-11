package be.ac.umons.emile.jeu.logique;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
public class Pieces extends Group {
    public int rota;

    public ArrayList<PlayableCases> shape=new ArrayList<>();
    public Pieces(char value) {
        if(value=='a'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));
        }else if(value=='b'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));

        }else if(value=='3'){
            shape.add(new PlayableCases(0,0));
        }else if(value=='4'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));


        }else if(value=='5'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(0,1));

        }else if(value=='6'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(-1,1));

        }else if(value=='7'){

            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));

        }else if(value=='8'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));


        }else if(value=='9'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(1,3));
            shape.add(new PlayableCases(1,4));
            shape.add(new PlayableCases(1,5));
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(0,3));
            shape.add(new PlayableCases(0,4));
            shape.add(new PlayableCases(0,5));



        }else if(value=='c'){//10
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));

        }else if(value=='d'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(-1,2));

        }else if(value=='e'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(-1,2));
            shape.add(new PlayableCases(-1,1));

        }else if(value=='f'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
        }else if(value=='g'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(-1,1));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(-1,2));

        }else if(value=='h'){//15
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));

        }else if(value=='i'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(-1,1));
            shape.add(new PlayableCases(-3,1));
            shape.add(new PlayableCases(-2,1));

        }else if(value=='j'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));

        }else if(value=='k'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));

        }else if(value=='l'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(1,3));
            shape.add(new PlayableCases(0,3));

        }else if(value=='m'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(1,3));
            shape.add(new PlayableCases(0,3));

        }else if(value=='n'){//21
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));

        }else if(value=='o'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(3,0));
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(0,1));

        }else if(value=='p'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(-1,1));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));

        }else if(value=='q'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(0,2));

        }else if(value=='r'){//25
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(1,1));

        }else if(value=='s'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(3,0));
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(3,2));
            shape.add(new PlayableCases(0,2));

        }else if(value=='t'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(4,1));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(4,0));

        }else if(value=='u'){
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(0,3));
            shape.add(new PlayableCases(-1,3));

        }else if(value=='v'){//29
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(-1,1));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(-1,2));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(-1,3));
            shape.add(new PlayableCases(0,3));
        }else{
            shape.add(new PlayableCases(0,0));
            shape.add(new PlayableCases(-1,1));
            shape.add(new PlayableCases(0,1));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(-1,2));
            shape.add(new PlayableCases(0,2));
            shape.add(new PlayableCases(1,2));

    }
        for(int i=0;i<shape.size();i++){
            getChildren().add(shape.get(i));
        }

    }




    public double maxX(){
        double max=0;
        for(PlayableCases c:shape){
            if(c.getX()>max){
                max=c.getX();
            }
        }
        return max;
    }

    public double minX(){
        double min;
        min=shape.get(0).getX();
        for(PlayableCases c:shape){
            if(c.getX()>min){
                min=c.getX();
            }
        }
        return min;
    }
    public double maxY(){
        double max=0;
        for(PlayableCases c:shape){
            if(c.getY()>max){
                max=c.getY();
            }
        }
        return max;
    }

    public double minY(){
        double min;
        min=shape.get(0).getY();
        for(PlayableCases c:shape){
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

    public void rotate(){
        double xc=getCenterX();
        double yc=getCenterY();

        for(PlayableCases c:shape){
            c.setX(xc-(c.getY()-yc));
            c.setY(yc+(c.getX()-xc));
        }

    }



}