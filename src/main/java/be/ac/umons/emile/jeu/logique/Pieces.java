package be.ac.umons.emile.jeu.logique;
import java.util.ArrayList;
public class Pieces {
    public ArrayList<PlayableCases> shape=new ArrayList<>();
    public int value;

    public Pieces(int value) {
        this.value = value;

        if(value==1){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));

        }else if(value==2){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(2,2,value));

        }else if(value==3){
            shape.add(new PlayableCases(1,0,value));

        }else if(value==4){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(3,0,value));
            shape.add(new PlayableCases(3,1,value));
            shape.add(new PlayableCases(3,2,value));


        }else if(value==5){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));

        }else if(value==6){
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(1,1,value));

        }else if(value==7){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(2,0,value));

        }else if(value==8){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(3,0,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(3,1,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(3,2,value));


        }else if(value==9){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(1,3,value));
            shape.add(new PlayableCases(1,4,value));
            shape.add(new PlayableCases(1,5,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(2,3,value));
            shape.add(new PlayableCases(2,4,value));
            shape.add(new PlayableCases(2,5,value));



        }else if(value==10){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));

        }else if(value==11){
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(3,0,value));
            shape.add(new PlayableCases(3,1,value));
            shape.add(new PlayableCases(3,2,value));
            shape.add(new PlayableCases(1,2,value));

        }else if(value==12){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));

        }else if(value==13){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(2,2,value));
        }else if(value==14){
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,2,value));

        }else if(value==15){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));

        }else if(value==16){
            shape.add(new PlayableCases(4,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(3,1,value));
            shape.add(new PlayableCases(4,1,value));

        }else if(value==17){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(3,0,value));
            shape.add(new PlayableCases(3,1,value));

        }else if(value==18){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(2,2,value));

        }else if(value==19){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(1,3,value));
            shape.add(new PlayableCases(2,3,value));

        }else if(value==20){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(1,3,value));
            shape.add(new PlayableCases(2,3,value));

        }else if(value==21){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));

        }else if(value==22){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(3,0,value));
            shape.add(new PlayableCases(4,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(3,1,value));
            shape.add(new PlayableCases(4,1,value));

        }else if(value==23){
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(2,2,value));

        }else if(value==24){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,2,value));

        }else if(value==25){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(3,1,value));

        }else if(value==26){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(3,0,value));
            shape.add(new PlayableCases(4,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(3,1,value));
            shape.add(new PlayableCases(4,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(3,2,value));
            shape.add(new PlayableCases(4,2,value));

        }else if(value==27){
            shape.add(new PlayableCases(1,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(3,1,value));
            shape.add(new PlayableCases(4,1,value));
            shape.add(new PlayableCases(5,1,value));
            shape.add(new PlayableCases(5,0,value));

        }else if(value==28){
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(2,3,value));
            shape.add(new PlayableCases(1,3,value));

        }else if(value==29){
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(1,3,value));
            shape.add(new PlayableCases(2,3,value));
        }else{
            shape.add(new PlayableCases(2,0,value));
            shape.add(new PlayableCases(1,1,value));
            shape.add(new PlayableCases(2,1,value));
            shape.add(new PlayableCases(3,1,value));
            shape.add(new PlayableCases(1,2,value));
            shape.add(new PlayableCases(2,2,value));
            shape.add(new PlayableCases(3,2,value));

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
    public void printPiece() {
        boolean cond = true;
        for (int i = 0; i < yMax() + 1; i++) {

            for (PlayableCases c : shape) {
                if (c.getY() == i)
                    System.out.print(c);

            }
        System.out.print("\n");
        }
    }

    /*Permet d'obtenir le y max d'une pièce

     */
    private int yMax(){
        int max=0;
        for (PlayableCases c: shape){
            if(c.getY()>max){
                max=c.getY();
            }
        }
        return max;
    }

    private int xMax(){
        int max=0;
        for(PlayableCases c: shape){
            if(c.getX()>max){
                max=c.getX();
            }
        }
        return max;
    }



}