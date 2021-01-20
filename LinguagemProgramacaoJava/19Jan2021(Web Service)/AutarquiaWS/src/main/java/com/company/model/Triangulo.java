/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

/**
 *
 * @author joaor
 */
public class Triangulo extends Terreno {

    private Double base;
    private Double altura;

    public Triangulo(String nome, Double base, Double altura) {
        super(nome, Shape.Triangulo);
    }

    @Override
    public double calcularAreaTerreno() {
        return (getBase()*getAltura())/2;
    }

    /**
     * @return the base
     */
    public Double getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(Double base) {
        this.base = base;
    }

    /**
     * @return the altura
     */
    public Double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(Double altura) {
        this.altura = altura;
    }

}
