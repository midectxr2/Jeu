package be.ac.umons.emile.jeu.logique;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



import java.util.ArrayList;
public class Pieces extends StackPane {

    public ArrayList<PlayableCases> shape=new ArrayList<>();

    public Pieces(char value) {
        if(value=='a'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
        }else if(value=='b'){
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(3,0));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(3,2));

        }else if(value=='3'){
            shape.add(new PlayableCases(1,0));
        }else if(value=='4'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(3,0));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(3,2));


        }else if(value=='5'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));

        }else if(value=='6'){
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(1,1));

        }else if(value=='7'){

            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,0));

        }else if(value=='8'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(3,2));


        }else if(value=='9'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(1,3));
            shape.add(new PlayableCases(1,4));
            shape.add(new PlayableCases(1,5));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(2,3));
            shape.add(new PlayableCases(2,4));
            shape.add(new PlayableCases(2,5));



        }else if(value=='c'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));

        }else if(value=='d'){
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(3,0));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(3,2));
            shape.add(new PlayableCases(1,2));

        }else if(value=='e'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));

        }else if(value=='f'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));
        }else if(value=='g'){
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));

        }else if(value=='h'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));

        }else if(value=='i'){
            shape.add(new PlayableCases(4,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(4,1));

        }else if(value=='j'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(3,0));
            shape.add(new PlayableCases(3,1));

        }else if(value=='k'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));

        }else if(value=='l'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(1,3));
            shape.add(new PlayableCases(2,3));

        }else if(value=='m'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(1,3));
            shape.add(new PlayableCases(2,3));

        }else if(value=='n'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));

        }else if(value=='o'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(3,0));
            shape.add(new PlayableCases(4,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
         shape.add(new PlayableCases(4,1));

        }else if(value=='p'){
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));

        }else if(value=='q'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));

        }else if(value=='r'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));

        }else if(value=='s'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(3,0));
            shape.add(new PlayableCases(4,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(4,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(3,2));
            shape.add(new PlayableCases(4,2));

        }else if(value=='t'){
            shape.add(new PlayableCases(1,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(4,1));
            shape.add(new PlayableCases(5,1));
            shape.add(new PlayableCases(5,0));

        }else if(value=='u'){
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(2,3));
            shape.add(new PlayableCases(1,3));

        }else if(value=='v'){
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(1,3));
            shape.add(new PlayableCases(2,3));
        }else{
            shape.add(new PlayableCases(2,0));
            shape.add(new PlayableCases(1,1));
            shape.add(new PlayableCases(2,1));
            shape.add(new PlayableCases(3,1));
            shape.add(new PlayableCases(1,2));
            shape.add(new PlayableCases(2,2));
            shape.add(new PlayableCases(3,2));

    }


    }




    /*rotation de la pièce
     */
    public void rotatePiece() {
        for(PlayableCases c:shape){
            c.rotate();
        }
    }

    /*Fonction à implémenter pour déplacer les pièces

     */
    public void movePiece() {

    }

    /*Affiche les pièces mais ne prend pas en compte le placement selon les coord x
    !!à corriger!!
     */

    /*Permet d'obtenir le y max d'une pièce

     */



}