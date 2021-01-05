/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposicao;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author upskills
 */
public class Exposicao implements Comparable<Exposicao> {

    private String designacao;
    private int anoRealizacao;
    private ArrayList<Quadro> quadrosExpostos;

    private static final String DESIGNACAO_OMISSA = "Sem Designacao";
    private static final int ANOREALIZACAO_OMISSO = 0;
    private static final ArrayList<Quadro> QUADROS_OMISSO = new ArrayList<Quadro>();

    public Exposicao(String designacao, int anoRealizacao, ArrayList<Quadro> quadros) {
        this.designacao = designacao;
        this.anoRealizacao = anoRealizacao;
        this.quadrosExpostos = new ArrayList<>(quadros);
    }
    
    public Exposicao(String designacao, int anoRealizacao){
        this.designacao = designacao;
        this.anoRealizacao = anoRealizacao;
        this.quadrosExpostos = QUADROS_OMISSO;
    }

    public Exposicao() {
        this.designacao = DESIGNACAO_OMISSA;
        this.anoRealizacao = ANOREALIZACAO_OMISSO;
        this.quadrosExpostos = QUADROS_OMISSO;
    }
    
    public Exposicao(Exposicao o){
        this.designacao = o.designacao;
        this.anoRealizacao = o.anoRealizacao;
        this.quadrosExpostos = new ArrayList<>(o.quadrosExpostos);
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
     * @return the anoRealizacao
     */
    public int getAnoRealizacao() {
        return anoRealizacao;
    }

    /**
     * @param anoRealizacao the anoRealizacao to set
     */
    public void setAnoRealizacao(int anoRealizacao) {
        this.anoRealizacao = anoRealizacao;
    }

    /**
     * @return the quadrosExpostos
     */
    public ArrayList<Quadro> getQuadrosExpostos() {
        return new ArrayList<>(quadrosExpostos);
    }

    /**
     * @param quadrosExpostos the quadrosExpostos to set
     */
    public void setQuadrosExpostos(ArrayList<Quadro> quadrosExpostos) {
        this.quadrosExpostos = quadrosExpostos;
    }

    public String toString() {
        return String.format("\nExposiçao : %s"
                + "\nAno Realizaçao : %d"
                + "\n--- Quadros Expostos ---"
                + "\n%s", designacao, anoRealizacao, this.listPaintingsOrderedByAuthor());
    }

    private StringBuilder listPaintingsOrderedByAuthor() {
        Collections.sort(quadrosExpostos);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < quadrosExpostos.size(); i++) {
            str.append(quadrosExpostos.get(i));
        }
        
        return str ;

    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Exposicao outraExpo = (Exposicao) outroObjeto;
        return this.quadrosExpostos == outraExpo.quadrosExpostos && anoRealizacao == outraExpo.anoRealizacao
                && designacao.equalsIgnoreCase(outraExpo.designacao);
    }

    public boolean addQuadro(Quadro quadro) {
        boolean flag = true;
        for (int i = 0; i < quadrosExpostos.size(); i++) {
            if (quadrosExpostos.get(i) == quadro) {
                flag = false;
            }
        }
        this.quadrosExpostos.add(quadro);
        return flag;
    }

    public boolean removeQuadro(Quadro quadro) {
        return this.quadrosExpostos.remove(quadro);
    }

    @Override
    public int compareTo(Exposicao o) {
        if (anoRealizacao < o.getAnoRealizacao()) {
            return -1;
        } else if (anoRealizacao > o.getAnoRealizacao()) {
            return 1;
        } else {
            return 0;
        }
    }
}
