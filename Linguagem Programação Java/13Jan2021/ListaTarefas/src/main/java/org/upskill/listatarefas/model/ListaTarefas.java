package org.upskill.listatarefas.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTarefas {

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;

    public ListaTarefas(List<Tarefa> lista) {
        listaTarefas = lista;
    }

    public ListaTarefas() {
        listaTarefas = new ArrayList<Tarefa>();
    }

    //implementar todas as funcionalidades necessárias


    @Override
    public String toString() {
        List<Tarefa> copia = new ArrayList<>(listaTarefas);

        StringBuilder s = new StringBuilder();
        for (Tarefa taref : copia) {
            s.append(taref);
            s.append("\n");
        }

        return s.toString().trim();
    }

    public String toStringOrdenado() {
        List<Tarefa> copia = new ArrayList<>(listaTarefas);
        Collections.sort(copia);
        Collections.reverse(copia);

        StringBuilder s = new StringBuilder();
        for (Tarefa taref : copia) {
            s.append(taref);
            s.append("\n");
        }

        return s.toString().trim();
    }

    public boolean adicionarNovaTarefa(String desc, Prioridade prio) {
        Tarefa tarefa = new Tarefa(desc, prio);
        return listaTarefas.contains(tarefa)
                ? false
                : listaTarefas.add(tarefa);
    }

    public void limparListaTarefa() {
        if (listaTarefas.isEmpty()) {
            throw new IllegalArgumentException("Lista Vazia!");
        } else {
            listaTarefas.clear();
        }
    }

    public boolean removerUltimaTarefa() {
        return listaTarefas.remove(listaTarefas.get(listaTarefas.size() - 1));
    }
}
