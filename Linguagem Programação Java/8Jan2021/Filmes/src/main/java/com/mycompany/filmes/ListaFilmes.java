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
    
    private String designacao;
    private List<Filme> listaFilmes ;
    
    
    public ListaFilmes(String designacao, List<Filme> listaFilmes){
        setDesignacao(designacao);
        this.listaFilmes = new ArrayList<Filme>(listaFilmes);
    }

    /**
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * @param Designacao the Designacao to set
     */
    public void setDesignacao(String designacao){
        this.designacao = designacao;
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
