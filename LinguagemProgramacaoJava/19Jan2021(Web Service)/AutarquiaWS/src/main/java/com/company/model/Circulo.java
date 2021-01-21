/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.RaioInvalidoException;
import java.io.Serializable;

/**
 *
 * @author joaor
 */
public class Circulo extends Terreno implements Serializable{

    private double raio;
    
    public Circulo() {
        
    }

    public Circulo(String name,Double raio) {
        super(name);
        setRaio(raio);
    }
   

    /**
     * @return the raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     * @param raio the raio to set
     */
    public void setRaio(double raio) throws RaioInvalidoException {
        if (raio > 0) {
            this.raio = raio;
        } else {
            throw new RaioInvalidoException("Raio do Circulo tem de ser Positivo");
        }
    }

    @Override
    public double calcularAreaTerreno() {
        return Math.PI * Math.pow(raio, 2);
    }

}
