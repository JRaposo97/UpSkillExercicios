/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.NomeTerrenoException;

/**
 *
 * @author joaor
 */
public abstract class Terreno {

    private String nome;
    private Shape shape;

    public Terreno(String nome, Shape shape) {
        this.nome = nome;
        this.shape = shape;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws NomeTerrenoException{
        if (nome != null) {
            this.nome = nome;
        } else {
            throw new NomeTerrenoException("Nome de Terreno não pode ser nulo");
        }
    }

    /**
     * @return the shape
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public abstract double calcularAreaTerreno();
}
