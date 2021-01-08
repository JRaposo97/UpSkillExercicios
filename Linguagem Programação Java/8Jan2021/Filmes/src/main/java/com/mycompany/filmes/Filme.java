/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmes;

import java.util.Calendar;

/**
 *
 * @author joaor
 */
public class Filme{

    private String titulo;
    private int anoRealizacao;
    private Realizador realizador;
    private Categoria categoria;
    
    private static final String TITULO_OMISSO = "Sem Titulo";
    private static final int ANOREALIZACAO_OMISSO = 2020;
    private static final Realizador REALIZADOR_OMISSO = new Realizador();
    private static final Categoria CATEGORIA_OMISSA = Categoria.Comedia;
    
    
    public Filme(String titulo, int anoRealizacao, Realizador realizador, Categoria categoria) throws AnoInvalidoException,CategoriaInvalidaException{
        setTitulo(titulo);
        setAnoRealizacao(anoRealizacao);
        setRealizador(realizador);
        setCategoria(categoria);
    }
    
    public Filme() throws AnoInvalidoException,CategoriaInvalidaException{
        setTitulo(TITULO_OMISSO);
        setAnoRealizacao(ANOREALIZACAO_OMISSO);
        setRealizador(REALIZADOR_OMISSO);
        setCategoria(CATEGORIA_OMISSA);
    }

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
    public int getAnoRealizacao() {
        return anoRealizacao;
    }

    /**
     * @param anoRealizacao the anoRealizacao to set
     */
    public void setAnoRealizacao(int anoRealizacao) throws AnoInvalidoException {
        if (anoRealizacao < 1850 || anoRealizacao > Data.dataAtual().getAno()){
            throw new AnoInvalidoException("O ano inserido não pode ser inferior a 1850 ou superior ao ano atual (Ano invalido: "+anoRealizacao+")");
        }
        this.anoRealizacao = anoRealizacao;
    }

    /**
     * @return the nomeRealizador
     */
    public Realizador getNomeRealizador() {
        return realizador;
    }

    /**
     * @param nomeRealizador the nomeRealizador to set
     */
    public void setRealizador(Realizador realizador)  {
        this.realizador = realizador;
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
    public void setCategoria(Categoria categoria) throws CategoriaInvalidaException {
        if(categoria != Categoria.Acao ||
           categoria != Categoria.Animacao ||
           categoria != Categoria.Comedia ||
           categoria != Categoria.Drama ||
           categoria != Categoria.Terror){
            throw new CategoriaInvalidaException("Escreva a Categoria corretamente (sem acentos)");
        }
        this.categoria = categoria;
    }

    private enum Categoria {
        Comedia, Acao, Terror, Drama, Animacao;
    }

}
