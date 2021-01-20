/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.NomeFreguesiaInvalidoException;
import java.io.Serializable;

/**
 *
 * @author joaor
 */
public class Freguesia implements Serializable, Comparable<Freguesia>{

    private String nomeFreguesia;

    public Freguesia(String nomeFreguesia) {
        setNomeFreguesia(nomeFreguesia);
    }
    
    public Freguesia(Freguesia f){
        setNomeFreguesia(f.nomeFreguesia);
    }

    /**
     * @return the nomeFreguesia
     */
    public String getNomeFreguesia() {
        return nomeFreguesia;
    }

    /**
     * @param nomeFreguesia the nomeFreguesia to set
     */
    public void setNomeFreguesia(String nomeFreguesia) {
        this.nomeFreguesia = nomeFreguesia;
    }
    
    public void setNome(String nomeFreguesia) throws NomeFreguesiaInvalidoException {
        if (eNomeFreguesiaValida(nomeFreguesia)) {
            this.nomeFreguesia = nomeFreguesia;
        } else {
            throw new NomeFreguesiaInvalidoException(nomeFreguesia + ": Nome Freguesia invalido");
        }
    }
    
    private boolean eNomeFreguesiaValida(String nomeFreguesia) {
        if (nomeFreguesia == null) {
            return false;
        }
        if (nomeFreguesia.length() < 3) {
            return false;
        }
        for (int i = 0; i < nomeFreguesia.length(); i++) {
            if (nomeFreguesia.charAt(i) >= '0' && nomeFreguesia.charAt(i) <= '9') {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Freguesia o) {
       return nomeFreguesia.compareToIgnoreCase(o.getNomeFreguesia());
    }

}
