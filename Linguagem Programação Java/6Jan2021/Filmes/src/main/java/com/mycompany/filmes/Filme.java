/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmes;

/**
 *
 * @author joaor
 */
public class Filme {

    private String titulo;
    private Data anoRealizacao;
    private String nomeRealizador;
    private Categoria categoria;

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the anoRealizacao
     */
    public Data getAnoRealizacao() {
        return anoRealizacao;
    }

    /**
     * @param anoRealizacao the anoRealizacao to set
     */
    public void setAnoRealizacao(Data anoRealizacao) {
        this.anoRealizacao = anoRealizacao;
    }

    /**
     * @return the nomeRealizador
     */
    public String getNomeRealizador() {
        return nomeRealizador;
    }

    /**
     * @param nomeRealizador the nomeRealizador to set
     */
    public void setNomeRealizador(String nomeRealizador) {
        this.nomeRealizador = nomeRealizador;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    private enum Categoria {
        Comedia, Acao, Terror, Drama, Animacao;
    }

}
