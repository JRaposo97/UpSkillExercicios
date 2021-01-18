/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposicao;

/**
 *
 * @author upskills
 */
public class Quadro implements Comparable<Quadro>{
    
    
    private String designacao;
    private String nomeAutor;
    private int anoCriacao;
    
    private static final String DESIGNACAO_OMISSA = "Sem Designaçao";
    private static final String NOMEAUTOR_OMISSA = "Sem Nome de Autor";
    private static final int ANOCRIACAO_OMISSO = 0;

    
    public Quadro(String designacao, String nomeAutor, int anoCriacao){
        this.designacao = designacao;
        this.nomeAutor = nomeAutor;
        this.anoCriacao = anoCriacao;
    }
    
    public Quadro(){
        this.designacao = DESIGNACAO_OMISSA;
        this.nomeAutor = NOMEAUTOR_OMISSA;
        this.anoCriacao = ANOCRIACAO_OMISSO;
    }
    /**
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * @param designacao the designacao to set
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * @return the nomeAutor
     */
    public String getNomeAutor() {
        return nomeAutor;
    }

    /**
     * @param nomeAutor the nomeAutor to set
     */
    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    /**
     * @return the anoCriacao
     */
    public int getAnoCriacao() {
        return anoCriacao;
    }

    /**
     * @param anoCriacao the anoCriacao to set
     */
    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }
    
    public String toString(){
        return String.format("\nAutor : %s\nAno de Criacao : %d\nDesignacao : %s\n", nomeAutor,anoCriacao,designacao);
    }


    
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Quadro outroQuadro = (Quadro) outroObjeto;
        return anoCriacao == outroQuadro.anoCriacao && nomeAutor.equalsIgnoreCase(outroQuadro.nomeAutor)
                && designacao.equalsIgnoreCase(outroQuadro.designacao);
    }
    
    
    @Override
    public int compareTo(Quadro o) {
       return nomeAutor.compareTo(o.nomeAutor);
    }
    
    
    
    
}
