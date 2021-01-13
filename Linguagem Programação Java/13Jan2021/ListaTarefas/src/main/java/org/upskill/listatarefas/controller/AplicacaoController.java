package org.upskill.listatarefas.controller;

import java.util.ArrayList;
import org.upskill.listatarefas.model.ListaTarefas;
import org.upskill.listatarefas.model.Prioridade;
import org.upskill.listatarefas.model.Tarefa;

public class AplicacaoController {

    private ListaTarefas lista;

    //inicia atributos
    public AplicacaoController() {
        lista = new ListaTarefas();
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        return lista.adicionarNovaTarefa(descricao, prioridade);
    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        return lista.removerUltimaTarefa();
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        if (lista == null) {
            return true;
        }
        return false;
    }

    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
         lista.limparListaTarefa();
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        return lista.toString();
    }

    //retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        return lista.toStringOrdenado();
    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        return Prioridade.getPrioridades();
    }
}
