/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author joaor
 */
public class FicheiroListaTarefa {

    public static final String NOME_FICHEIRO_SERIALIZAR = "ListaTarefa.ltf";

    public FicheiroListaTarefa() {
    }

    public boolean serializar(ListaTarefas listaTarefas) {
        return serializar(NOME_FICHEIRO_SERIALIZAR, listaTarefas);
    }

    public boolean serializar(String nomeFicheiro, ListaTarefas listaTarefas) {
        return serializar(new File(nomeFicheiro), listaTarefas);
    }

    public boolean serializar(File ficheiro, ListaTarefas listaTarefas) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(ficheiro));
            try {
                out.writeObject(listaTarefas);

                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public ListaTarefas desserializar() {
        return desserializar(NOME_FICHEIRO_SERIALIZAR);
    }

    public ListaTarefas desserializar(String nomeFicheiro) {
        return desserializar(new File(nomeFicheiro));
    }

    public ListaTarefas desserializar(File ficheiro) {
        ListaTarefas listaTelefonica;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(ficheiro));
            try {
                listaTelefonica = (ListaTarefas) in.readObject();

                return listaTelefonica;
            } finally {
                in.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            return new ListaTarefas();
        }
    }

    public static boolean exportarTexto(File ficheiro, ListaTarefas listaTarefas) {
        try {
            PrintWriter out = new PrintWriter(ficheiro);
            String[] listaTarefaParaFicheiro = listaTarefas.getListaComoArray();

            try {
                for (int i = 0; i < listaTarefaParaFicheiro.length - 1; i++) {
                    out.print(listaTarefaParaFicheiro[i] + "\n");
                }
                out.print(listaTarefaParaFicheiro[listaTarefaParaFicheiro.length - 1]);

                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public ListaTarefas importarTexto(File ficheiro) {
        try {
            ListaTarefas lista = new ListaTarefas();
            Scanner in = new Scanner(ficheiro);
            Prioridade pr = null;

            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    String[] dadosTarefa = Tarefa.getTarefaComoArray(linha);

                    for (Prioridade p : Prioridade.values()) {
                        if (p.toString() == dadosTarefa[2]) {
                            pr = p;
                        }
                    }

                    lista.adicionarNovaTarefa(dadosTarefa[1], pr);
                }

                return lista;
            } finally {
                in.close();
            }
        } catch (IOException ex) {
            return new ListaTarefas();
        }
    }

}
