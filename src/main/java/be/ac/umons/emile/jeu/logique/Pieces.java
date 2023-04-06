package be.ac.umons.emile.jeu.logique;
import java.util.ArrayList;
import java.util.List;
public class Pieces {
    private Cases[] shape=new Cases[12];
    private int value;

    public Pieces(int value) {
        this.value = value;
        if(value==1){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(1,2,value);


        }else if(value==2){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(1,2,value);
            shape[4]=new PlayableCases(2,0,value);
            shape[5]=new PlayableCases(2,1,value);
            shape[6]=new PlayableCases(2,2,value);

        }else if(value==3){
            shape[1]=new PlayableCases(1,0,value);

        }else if(value==4){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(1,2,value);
            shape[4]=new PlayableCases(2,0,value);
            shape[5]=new PlayableCases(2,1,value);
            shape[6]=new PlayableCases(2,2,value);
            shape[7]=new PlayableCases(3,0,value);
            shape[8]=new PlayableCases(3,1,value);
            shape[9]=new PlayableCases(3,2,value);


        }else if(value==5){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);

        }else if(value==6){
            shape[1]=new PlayableCases(2,0,value);
            shape[2]=new PlayableCases(2,1,value);
            shape[3]=new PlayableCases(1,1,value);

        }else if(value==7){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,0,value);
            shape[4]=new PlayableCases(2,0,value);

        }else if(value==8){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(2,0,value);
            shape[3]=new PlayableCases(3,0,value);
            shape[4]=new PlayableCases(2,1,value);
            shape[5]=new PlayableCases(3,1,value);
            shape[6]=new PlayableCases(2,2,value);
            shape[7]=new PlayableCases(3,2,value);


        }else if(value==9){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(1,2,value);
            shape[4]=new PlayableCases(1,3,value);
            shape[5]=new PlayableCases(1,4,value);
            shape[6]=new PlayableCases(1,5,value);
            shape[7]=new PlayableCases(2,0,value);
            shape[8]=new PlayableCases(2,1,value);
            shape[9]=new PlayableCases(2,2,value);
            shape[10]=new PlayableCases(2,3,value);
            shape[11]=new PlayableCases(2,4,value);
            shape[12]=new PlayableCases(2,5,value);



        }else if(value==10){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);

        }else if(value==11){
            shape[1]=new PlayableCases(2,0,value);
            shape[2]=new PlayableCases(2,1,value);
            shape[3]=new PlayableCases(2,2,value);
            shape[4]=new PlayableCases(3,0,value);
            shape[5]=new PlayableCases(3,1,value);
            shape[6]=new PlayableCases(3,2,value);
            shape[7]=new PlayableCases(1,2,value);

        }else if(value==12){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(1,2,value);
            shape[4]=new PlayableCases(1,0,value);
            shape[5]=new PlayableCases(1,1,value);
            shape[6]=new PlayableCases(1,2,value);
            shape[7]=new PlayableCases(1,0,value);
            shape[8]=new PlayableCases(1,1,value);

        }else if(value==13){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(1,2,value);
            shape[4]=new PlayableCases(2,1,value);
            shape[5]=new PlayableCases(2,2,value);
        }else if(value==14){
            shape[1]=new PlayableCases(2,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(1,2,value);
            shape[5]=new PlayableCases(2,2,value);

        }else if(value==15){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(2,0,value);
            shape[3]=new PlayableCases(1,1,value);
            shape[4]=new PlayableCases(1,2,value);

        }else if(value==16){
            shape[1]=new PlayableCases(4,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(3,1,value);
            shape[5]=new PlayableCases(4,1,value);

        }else if(value==17){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,0,value);
            shape[4]=new PlayableCases(3,0,value);
            shape[5]=new PlayableCases(3,1,value);

        }else if(value==18){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(2,2,value);

        }else if(value==19){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(2,0,value);
            shape[3]=new PlayableCases(1,1,value);
            shape[4]=new PlayableCases(2,1,value);
            shape[5]=new PlayableCases(1,2,value);
            shape[6]=new PlayableCases(2,2,value);
            shape[7]=new PlayableCases(1,3,value);
            shape[8]=new PlayableCases(2,3,value);

        }else if(value==20){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(1,2,value);
            shape[5]=new PlayableCases(2,2,value);
            shape[6]=new PlayableCases(1,3,value);
            shape[7]=new PlayableCases(2,3,value);

        }else if(value==21){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(1,2,value);
            shape[4]=new PlayableCases(1,0,value);
            shape[5]=new PlayableCases(1,1,value);

        }else if(value==22){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(2,0,value);
            shape[3]=new PlayableCases(3,0,value);
            shape[4]=new PlayableCases(4,0,value);
            shape[5]=new PlayableCases(1,1,value);
            shape[6]=new PlayableCases(2,1,value);
            shape[7]=new PlayableCases(3,1,value);
            shape[8]=new PlayableCases(4,1,value);

        }else if(value==23){
            shape[1]=new PlayableCases(2,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(2,2,value);

        }else if(value==24){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(1,2,value);
            shape[4]=new PlayableCases(2,2,value);

        }else if(value==25){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(2,0,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(3,1,value);

        }else if(value==26){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(2,0,value);
            shape[3]=new PlayableCases(3,0,value);
            shape[4]=new PlayableCases(4,0,value);
            shape[5]=new PlayableCases(1,1,value);
            shape[6]=new PlayableCases(2,1,value);
            shape[7]=new PlayableCases(3,1,value);
            shape[8]=new PlayableCases(4,1,value);
            shape[9]=new PlayableCases(1,2,value);
            shape[10]=new PlayableCases(2,2,value);
            shape[11]=new PlayableCases(3,2,value);
            shape[12]=new PlayableCases(4,2,value);

        }else if(value==27){
            shape[1]=new PlayableCases(1,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(3,1,value);
            shape[5]=new PlayableCases(4,1,value);
            shape[6]=new PlayableCases(5,1,value);
            shape[7]=new PlayableCases(5,0,value);

        }else if(value==28){
            shape[1]=new PlayableCases(2,0,value);
            shape[2]=new PlayableCases(2,1,value);
            shape[3]=new PlayableCases(2,2,value);
            shape[4]=new PlayableCases(2,3,value);
            shape[5]=new PlayableCases(1,3,value);

        }else if(value==29){
            shape[1]=new PlayableCases(2,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(1,2,value);
            shape[5]=new PlayableCases(2,2,value);
            shape[6]=new PlayableCases(1,3,value);
            shape[7]=new PlayableCases(2,3,value);
        }else{
            shape[1]=new PlayableCases(2,0,value);
            shape[2]=new PlayableCases(1,1,value);
            shape[3]=new PlayableCases(2,1,value);
            shape[4]=new PlayableCases(3,1,value);
            shape[5]=new PlayableCases(1,2,value);
            shape[6]=new PlayableCases(2,2,value);
            shape[7]=new PlayableCases(3,2,value);

        }
        for(int i=0;i<12;i++){
            if(shape[i]==null){
                shape[i]=new PlayableCases(0,0,0);
            }
        }
    }


    /*rotation de la pièce
     */
    public void rotatePiece() {

    }

    /*Fonction à implémenter pour déplacer les pièces

     */
    public void movePiece() {

    }

    /*Affiche les pièces mais ne prend pas en compte le placement selon les coord x
    !!à corriger!!
     */
    public void printPiece() {

    }

    /*Permet d'ajouter des cases à la pièce*/
    public void addCases( PlayableCases object) {

    }
    /*Permet d'obtenir le y max d'une pièce

     */
    public int yMax(){
        int max=0;
        return max;
    }



}