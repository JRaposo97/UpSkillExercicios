/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.segmentoreta;

import static java.lang.Math.*;

/**
 *
 * @author upskills
 */
public class SegmentoReta {

    private Ponto ponto1;
    private Ponto ponto2;

    private static final Ponto P1_OMISSO = new Ponto();
    private static final Ponto P2_OMISSO = new Ponto();

    /**
     * @return the ponto1
     */
    public Ponto getPonto1() {
        return ponto1;
    }

    /**
     * @param ponto1 the ponto1 to set
     */
    public void setPonto1(Ponto ponto1) {
        this.ponto1 = ponto1;
    }

    /**
     * @return the ponto2
     */
    public Ponto getPonto2() {
        return ponto2;
    }

    /**
     * @param ponto2 the ponto2 to set
     */
    public void setPonto2(Ponto ponto2) {
        this.ponto2 = ponto2;
    }

    public SegmentoReta(Ponto inicio, Ponto fim) {
        this.ponto1 = inicio;
        this.ponto2 = fim;
    }

    public SegmentoReta() {
        this.ponto1 = P1_OMISSO;
        this.ponto2 = P2_OMISSO;
    }

    public double lenght() {
        double x = ponto1.getX() - ponto2.getX();
        double y = ponto1.getY() - ponto2.getY();

        return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
    }

    public double slope() {
        double rise = ponto2.getY() - ponto1.getY();
        double run = ponto2.getX() - ponto2.getX();

        return rise / run;
    }

    public void move(int dx, int dy) {
        
        this.ponto1.move(dx, dy);
        this.ponto2.move(dx, dy);

    }

}
