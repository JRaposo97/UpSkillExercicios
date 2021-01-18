/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import com.mycompany.model.Atleta;
import com.mycompany.model.ClubeDesportivo;

/**
 *
 * @author joaor
 */
public class AppController {
    
    private ClubeDesportivo clube;
    
    //inicia atributos
    public AppController() {
        this.clube = new ClubeDesportivo();
    }

    public boolean isListaVazia() {
        return clube.isListaVazia();
    }

    public boolean adicionarAtletaProfissional(String nome, int nic, int dia, int mes, int ano, String genero, String atividade, int FCR,int diaRegisto, int mesRegisto, int anoRegisto, double parcelaFixa) {
//        return clube.addAtletaProfissional(nome, nic, dia, mes, ano, genero, atividade, FCR, diaRegisto, mesRegisto, anoRegisto, parcelaFixa);
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    }

    public boolean adicionarAtletaSemiProfissional(String nome, int nic, int diaNascimento, int mesNascimento, int anoNascimento, String genero, String atividade, int FCR, int diaRegisto, int mesRegisto, int anoRegisto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean adicionarAtletaAmador(String nome, int nic, int diaNascimento, int mesNascimento, int anoNascimento, String genero, String atividade, int FCR, int diaRegisto, int mesRegisto, int anoRegisto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ObservableList<Atleta> getListaAtletas() {
       return clube.getAtletasObs();
    }

    
}
