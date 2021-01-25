/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.NomeTerrenoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaor
 */
public abstract class Terreno implements Serializable {

    private static int count = 0;
    private int id;
    private String nome;
    private List<Pessoa> proprietarios;

    public Terreno() {
    }

    public Terreno(String nome) {
        id = ++count;
        this.nome = nome;
    }

    public Terreno(Terreno terreno) {
        id = ++count;
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

    /**
     * @return the proprietarios
     */
    public ArrayList<Pessoa> getProprietarios() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.proprietarios.size(); i++) {
            pessoa = this.proprietarios.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copia = new Pessoa(pessoa);
                lista.add(copia);
            }
        }
        return lista;
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

    public boolean addProprietario(Pessoa p) {
        if (proprietarios.contains(p)) {
            throw new RuntimeException("O " + p.getNome() + "já é proprietario deste terreno");
        } else {
            return getProprietarios().add(p);
        }
    }

    public boolean removeProprietario(Pessoa p) throws Exception {
        if(proprietarios.contains(p)){
            return proprietarios.remove(p);
        }else{
            throw new Exception(p.getNome()+"Não é proprietario deste terreno");
        }
    }

}
