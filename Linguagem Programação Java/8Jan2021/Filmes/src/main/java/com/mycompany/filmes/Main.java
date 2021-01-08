/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joaor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Realizador r1 = new Realizador("Jordan", "Americano", new Data(1920, 1, 1));
            Realizador r2 = new Realizador("Mario", "Italiano", new Data(1920, 2, 21));
            Filme f1 = new Filme("Filme 1", 1900, r1, "Acao");
            Filme f2 = new Filme("Filme 2", 1900, r1, "ACAO");
            Filme f3 = new Filme("Filme 3", 2020, r2, "ACAO");
            Filme f4 = new Filme("Filme 4", 2020, r2, "TERROR");
            ArrayList<Filme> listaFilmes = new ArrayList<Filme>();
            listaFilmes.add(f1);
            listaFilmes.add(f2);
            listaFilmes.add(f3);
            listaFilmes.add(f4);
            ListaFilmes l1 = new ListaFilmes("abc",listaFilmes);
            ListaFilmes l2 = new ListaFilmes("ABC",listaFilmes);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
