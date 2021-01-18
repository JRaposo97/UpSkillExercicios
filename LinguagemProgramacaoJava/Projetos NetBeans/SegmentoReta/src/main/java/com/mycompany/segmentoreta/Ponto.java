/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.segmentoreta;

/**
 *
 * @author upskills
 */
public class Ponto {

    private int x;
    private int y;
    
    private static final int X_OMISSO = 0;
    private static final int Y_OMISSO = 0;
    
    public Ponto(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public Ponto(){
        this.x = X_OMISSO;
        this.y = Y_OMISSO;
    }
    
    public Ponto(Ponto oldPonto){
        this.x = oldPonto.getX();
        this.y = oldPonto.getY();
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public String toString(){
        return String.format("Ponto X: %d || Ponto Y: %d",x,y);
    }

    public void move(int dx,int dy){
        
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);
        
    }
}
