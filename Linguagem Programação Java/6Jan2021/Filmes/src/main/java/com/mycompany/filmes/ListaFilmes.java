/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmes;

import java.util.List;

/**
 *
 * @author joaor
 */
public class ListaFilmes {

    /**
     * @return the Designacao
     */
    public String getDesignacao() {
        return Designacao;
    }

    /**
     * @param Designacao the Designacao to set
     */
    public void setDesignacao(String Designacao) {
        this.Designacao = Designacao;
    }

    /**
     * @return the listaFilmes
     */
    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    /**
     * @param listaFilmes the listaFilmes to set
     */
    public void setListaFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }
    private String Designacao;
    private List<Filme> listaFilmes ;
}
