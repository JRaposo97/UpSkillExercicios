/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.AlturaRectanguloNegativeOrNullException;
import com.company.exception.CumpRectanguloNegativeOrNullException;

/**
 *
 * @author joaor
 */
public class Rectangulo extends Terreno {

    private Double altura;
    private Double cumprimento;

    public Rectangulo(String nome, Double altura, Double cumprimento) throws AlturaRectanguloNegativeOrNullException, CumpRectanguloNegativeOrNullException {
        super(nome, Shape.Rectangulo);
        setAltura(altura);
        setCumprimento(cumprimento);
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
    public void setAltura(Double altura) throws AlturaRectanguloNegativeOrNullException {
        if (altura == null || altura < 0) {
            throw new AlturaRectanguloNegativeOrNullException("Altura tem de ser um numero positivo.");
        } else {
            this.altura = altura;
        }
    }

    /**
     * @return the cumprimento
     */
    public Double getCumprimento() {
        return cumprimento;
    }

    /**
     * @param cumprimento the cumprimento to set
     */
    public void setCumprimento(Double cumprimento) throws CumpRectanguloNegativeOrNullException {
         if (cumprimento == null || cumprimento < 0) {
            throw new CumpRectanguloNegativeOrNullException("Cumprimento tem de ser um numero positivo.");
        } else {
            this.cumprimento = cumprimento;
        }
    }

    @Override
    public double calcularAreaTerreno() {
        return cumprimento*altura;
    }
}
