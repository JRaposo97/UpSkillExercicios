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

    private static int count = 0;
    private int id;
    private String nome;

    public Terreno() {
    }

    public Terreno(String nome) {
        ++id;
        this.nome = nome;
    }

    public Terreno(Terreno terreno) {
        ++id;
        this.nome = terreno.nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void setNome(String nome) throws NomeTerrenoException {
        if (nome != null) {
            this.nome = nome;
        } else {
            throw new NomeTerrenoException("Nome de Terreno não pode ser nulo");
        }
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
        return this.id == terreno.getId() && this.nome == terreno.getNome();
    }
    
     public abstract double calcularAreaTerreno();

}
