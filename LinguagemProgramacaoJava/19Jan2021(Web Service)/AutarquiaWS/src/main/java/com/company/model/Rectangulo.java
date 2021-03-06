/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.AlturaNegativeOrNullException;
import com.company.exception.CumpRectanguloNegativeOrNullException;
import java.io.Serializable;

/**
 *
 * @author joaor
 */
public class Rectangulo extends Terreno implements Serializable{

    private Double altura;
    private Double cumprimento;
    
    public Rectangulo(){
        
    }

    public Rectangulo(String nome,Double altura, Double cumprimento) throws AlturaNegativeOrNullException, CumpRectanguloNegativeOrNullException {
        super(nome);
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
    public void setAltura(Double altura) throws AlturaNegativeOrNullException {
        if (altura == null || altura < 0) {
            throw new AlturaNegativeOrNullException("Altura tem de ser um numero positivo.");
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
