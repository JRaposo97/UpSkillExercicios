/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.ElementoNaoExistenteException;
import com.company.exception.NifDuplicadoException;
import com.company.exception.NomeFreguesiaDuplicadoException;
import com.company.exception.NomeFreguesiaInvalidoException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joaor
 */
public class Freguesia implements Serializable, Comparable<Freguesia> {

    private String nomeFreguesia;
    private ArrayList<Terreno> terrenos;

    public Freguesia(String nomeFreguesia) {
        setNomeFreguesia(nomeFreguesia);
        this.terrenos = new ArrayList<>();
    }

    public Freguesia(Freguesia f) {
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

    //Freguesias
    ArrayList<Terreno> getTerrenos() {
        return terrenos;
    }

    public Terreno getTerreno(int id) {
        return getTerrenoByID(id);
    }

    public void addTerreno(Terreno terreno) {
        Terreno t = getTerrenoByID(terreno.getId());
        if (t == null) {
            this.terrenos.add(terreno);
        }
    }

    private Terreno getTerrenoByID(int id) {
        Terreno terr = null;
        for (int i = 0; i < this.terrenos.size(); i++) {
            terr = this.terrenos.get(i);
            if (terr.getId() == id) {
                return terr;
            }
        }
        return null;
    }

    public void removeTerreno(int idTerreno) throws ElementoNaoExistenteException {
        Terreno terr = null;
        for (int i = 0; i < this.terrenos.size(); i++) {
            terr = this.terrenos.get(i);
            if (terr.getId() == idTerreno) {
                this.terrenos.remove(i);
                return;
            }
        }
        throw new ElementoNaoExistenteException(nomeFreguesia + ": Não existe esse Terreno");
    }

    public ArrayList<Pessoa> getProprietarios(int idTerreno) throws Exception {
        Terreno t = getTerrenoByID(idTerreno);
        if (t != null) {
            return t.getProprietarios();
        }else{
            throw new Exception("Terreno não existe");
        }

    }

    public boolean removeProprietarioTerreno(int idTerreno, Pessoa p) throws Exception {
        Terreno t = getTerrenoByID(idTerreno);
        if(t==null){
            throw new ElementoNaoExistenteException("Terreno não Existe");
        }else{
           return t.removeProprietario(p);
        }
    }

}
