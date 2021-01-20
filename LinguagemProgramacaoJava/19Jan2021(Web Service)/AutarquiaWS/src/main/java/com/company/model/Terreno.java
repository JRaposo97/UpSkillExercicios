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
public class Terreno {
    
    private static int count = 0;
    private int id;
    private String nome;
    private Forma forma;

    
    public Terreno(String nome, Forma forma) {
        ++id;
        this.nome = nome;
        this.forma = forma;
    }
    
    public Terreno(Terreno terreno){
        this.nome = terreno.nome;
        this.forma = terreno.forma;
    }
    
    
    public int getId() {
      return id;
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
    public Forma getShape() {
        return forma;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(Forma forma) {
        this.forma = forma;
    }

     @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Terreno terreno = (Terreno) outroObjeto;
        return this.id == terreno.getId() && this.forma == terreno.getShape();
    }
    
}
