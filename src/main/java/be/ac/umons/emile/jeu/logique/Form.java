package be.ac.umons.emile.jeu.logique;

import java.util.ArrayList;

public class Form {
    public ArrayList<PlayableCases> form=new ArrayList<>();
    public int value;

    public Form(int value){
        this.value=value;


        if(value==1){
            for(int i = 1; i < 6; i++){
                for(int j = 1; j < 6; j++){
                    form.add(new PlayableCases(i, j, value));
                }
            }

        }
        if(value == 2){
            for(int i = 1; i < 5; i++){
                for(int j = 1; j < 5; j++){
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for(PlayableCases p:form) {
                if (p.getX() == 1 && p.getY() == 4)
                    p.value = 0;
                if (p.getX() == 2 && p.getY() == 2)
                    p.value = 0;
            }
        }

        if(value == 3){
            for(int i = 1; i < 7; i++){
                for(int j = 1; j < 7; j++){
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for(PlayableCases p:form) {
                if (p.getX() == 1 && p.getY() == 1)
                    p.value = 0;
                if (p.getX() == 1 && p.getY() == 2)
                    p.value = 0;
                if (p.getX() == 6 && p.getY() == 5)
                    p.value = 0;
                if (p.getX() == 6 && p.getY() == 6)
                    p.value = 0;
            }
        }
        if(value == 4){
            for(int i = 1; i < 7; i++){
                for(int j = 1; j < 7; j++){
                    form.add(new PlayableCases(i, j, value));
                }
            }

        }
        if(value == 5){
            for(int i = 1; i < 8; i++){
                for(int j = 1; j < 8; j++){
                    form.add(new PlayableCases(i, j, value));
                }
            }

        }
        if(value == 6){
            for(int i = 1; i < 9; i++){
                for(int j = 1; j < 9; j++){
                    form.add(new PlayableCases(i, j, value));
                }
            }

        }
        if(value == 7) {
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 7; j++) {
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == 6 && p.getY() == 1)
                    p.value = 0;
            }
        }
        if(value == 8){
            for(int i = 1; i < 8; i++){
                for(int j = 1; j < 8; j++){
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == 1 && p.getY() == 6)
                    p.value = 0;
                if (p.getX() == 4 && p.getY() == 1)
                    p.value = 0;
            }
        }
        if(value == 9) {
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 7; j++) {
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == 1 && p.getY() == 6)
                    p.value = 0;
            }
        }
        if(value == 10) {
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == 3 && p.getY() == 1)
                    p.value = 0;
            }
        }
        if(value == 11) {
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == 1 && p.getY() == 1)
                    p.value = 0;
                if (p.getX() == 5 && p.getY() == 1)
                    p.value = 0;
                if (p.getX() == 3 && p.getY() == 2)
                    p.value = 0;
            }
        }
        if(value == 12) {
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 7; j++) {
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == 1 && p.getY() == 1)
                    p.value = 0;
                if (p.getX() == 5 && p.getY() == 1)
                    p.value = 0;
            }
        }
        if(value == 13) {
            for (int i = 1; i < 8; i++) {
                for (int j = 1; j < 8; j++) {
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == 4 && p.getY() == 1)
                    p.value = 0;
            }
        }
        if(value == 14) {
            for (int i = 1; i < 8; i++) {
                for (int j = 1; j < 8; j++) {
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == p.getY())
                    p.value = 0;
            }
        }
        if(value == 15) {
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 7; j++) {
                    form.add(new PlayableCases(i, j, value));
                }
            }
            for (PlayableCases p : form) {
                if (p.getX() == 1 && p.getY() == 1)
                    p.value = 0;
                if (p.getX() == 2 && p.getY() == 1)
                    p.value = 0;
                if (p.getX() == 6 && p.getY() == 5)
                    p.value = 0;
                if (p.getX() == 6 && p.getY() == 6)
                    p.value = 0;
            }
        }
    }
}
