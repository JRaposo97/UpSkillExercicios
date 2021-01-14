package org.upskill.listatarefas.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa implements Comparable<Tarefa> {

    private String descricao;
    private LocalDateTime instante;
    private Prioridade prioridade;

    private static final char SEPARADOR = ';';

    public Tarefa(String descricao, Prioridade prioridade) {
        setDescricao(descricao);
        setPrioridade(prioridade);
        instante = LocalDateTime.now();
    }

    public Tarefa(Tarefa tarefa) {
        this.descricao = tarefa.descricao;
        this.prioridade = tarefa.prioridade;
        this.instante = tarefa.instante;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public final void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida!");
        }
        this.descricao = descricao;
    }

    public final void setPrioridade(Prioridade prioridade) {
        if (prioridade == null) {
            throw new IllegalArgumentException("Prioridade inválida!");
        }
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoInstante
                = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS.SSS");
        String stringDataTempoDeRegisto = instante.format(formatoInstante);
        return String.format("%s - %s - %s", descricao, prioridade,
                stringDataTempoDeRegisto);
    }

    @Override
    public int compareTo(Tarefa outraTarefa) {
        if (prioridade.equals(outraTarefa.prioridade)) {
            return instante.compareTo(outraTarefa.instante);
        }

        return prioridade.compareTo(outraTarefa.prioridade);
    }

    public String toStringExport() {
        return String.format("%s%c%s%c%s", descricao, SEPARADOR, prioridade.toString(),SEPARADOR,instante.toString());
    }

    public static final String[] getTarefaComoArray(String tarefa) {
        String[] dados = tarefa.trim().split(String.valueOf(SEPARADOR));
        int nrAtributos = 2;
        Prioridade pr = null;
        
        for(Prioridade p : Prioridade.values()){
            if (p.toString()==dados[2]){
                pr = p;
            }
        }

        if (dados.length == nrAtributos) {
            try {
                new Tarefa(dados[1],pr);
                
                return dados;
            }
            catch(Exception ex) {
                throw new RuntimeException("Dados Inválidos da Tarefa");
            }
        }

        throw new RuntimeException("Dados Inválidos da Tarefa");
    }
}
