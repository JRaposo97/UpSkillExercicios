/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaor
 */
public class ListaFilmes {
    
    private String identificador;
    private List<Filme> listaFilmes ;
    
    
    public ListaFilmes(String identificador, List<Filme> listaFilmes){
        setIdentificador(identificador);
        this.listaFilmes = new ArrayList<Filme>(listaFilmes);
    }

    /**
     * @return the designacao
     */
    public String getDesignacao() {
        return identificador;
    }

    /**
     * @param Designacao the Designacao to set
     */
    public void setIdentificador(String identificador) throws IdentificadorInvalidoException{
        this.identificador = identificador;
    }

    /**
     * @return the listaFilmes
     */
    public List<Filme> getListaFilmes() {
        return new ArrayList<Filme>(listaFilmes);
    }

    /**
     * @param listaFilmes the listaFilmes to set
     */
    public void setListaFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }
}
