/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.AlturaNegativeOrNullException;
import com.company.exception.BaseNegativeOrNull;
import java.io.Serializable;

/**
 *
 * @author joaor
 */
public class Triangulo extends Terreno implements Serializable{

    private Double base;
    private Double altura;

    public Triangulo() {

    }
    
    public Triangulo(String nome,Double base, Double altura) throws BaseNegativeOrNull, AlturaNegativeOrNullException {
        super(nome);
        setBase(base);
        setAltura(altura);
    }

    @Override
    public double calcularAreaTerreno() {
        return (getBase() * getAltura()) / 2;
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
    public void setBase(Double base) throws BaseNegativeOrNull {
        if (base == null || base < 0) {
            throw new BaseNegativeOrNull("Base tem de ser um numero positivo.");
        } else {
            this.base = base;
        }
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
}
