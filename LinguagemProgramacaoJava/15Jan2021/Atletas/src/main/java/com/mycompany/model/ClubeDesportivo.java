package com.mycompany.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author diana
 */
public class ClubeDesportivo {

    /**
     * declaração de variáveis
     */
    private String nome;
    private Calendar dataFundacao;
    private ArrayList<Atleta> atletas;

    /**
     * declaração e inicialização de variáveis
     */
    private static final String NOME_OMISSO = "Sem Nome";
    private static final Calendar DATAFUNDACAO_OMISSO = Calendar.getInstance();
    private static final ArrayList ATLETAS_OMISSO = new ArrayList<Atleta>();

    /**
     * construtor para atribuir variáveis com os valores de entrada
     *
     * @param nome nome do clube
     * @param dia dia da Fundação do clube
     * @param mes mês da Fundação do clube
     * @param ano ano da Fundação do clube
     * @param atletas lista de objectos do tipo Atleta
     */
    public ClubeDesportivo(String nome, int dia, int mes, int ano, ArrayList<Atleta> atletas) {
        this.nome = nome;
        this.dataFundacao = Calendar.getInstance();
        this.atletas = atletas;
        dataFundacao.set(ano, mes, dia);
    }

    /**
     * construtor vazio para atribuir variáveis por omissão
     */
    public ClubeDesportivo() {
        this.nome = NOME_OMISSO;
        this.dataFundacao = DATAFUNDACAO_OMISSO;
        this.atletas = ATLETAS_OMISSO;
    }

    /**
     * @return nome do clube
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return lista de atletas
     */
    public ArrayList<Atleta> getAtletas() {
        ArrayList<Atleta> copyAtletas = new ArrayList<>(atletas);
        return copyAtletas;
    }
    
    /**
     * @return lista de atletas
     */
    public ObservableList<Atleta> getAtletasObs() {
        ObservableList<Atleta> listaAtletas = FXCollections.observableArrayList(atletas);
        
        return listaAtletas;
    }

    /**
     * método para adicionar atletas ao ArryList de Atletas
     *
     * @param pessoa atleta que vai ser adicionada à lista de atletas do clube
     */
    public boolean addAtleta(Atleta atleta) {
        return atletas.contains(atleta)
                ? false
                : atletas.add(atleta);
    }

    /**
     * @return total , valor total de impostos pagos pelo Clube
     */
    public double valorTotalImpostos() {
        double total = 0;
        for (int i = 0; i < atletas.size(); i++) {
            total += atletas.get(i).getImpostoIRS();
        }
        return total;
    }

    /**
     * função que ordena uma lista segundo determinados parametros
     *
     * @return atletas, ordena uma lista de atletas por ordem alfabética de nome
     * de acordo com o CompareTo da classe Atleta
     */
    public ArrayList<Atleta> ListOrdNomes() {
        Collections.sort(atletas);

        return atletas;
    }

    /**
     * função que ordena uma lista segundo determinados parametros
     *
     * @return atletas , lista de atletas por ordem decrescente do valor mensal
     * arrecadado por atleta de acordo com a classe ListOrdInversoValor que
     * implementa a Interface Comparator
     */
    public ArrayList<Atleta> ListarOrdemInversaValor() {
        Collections.sort(atletas, new ListOrdInversoValor());

        return atletas;
    }

    /**
     * função que ordena uma lista segundo determinados parametros
     *
     * @return atletas , lista de atletas ordenada por categoria, modalidade e
     * nome de acordo com a classe ListOrdCategModName que implementa a
     * Interface Comparator
     */
    public ArrayList<Atleta> ListOrdCategModName() {
        Collections.sort(atletas, new ListOrdCategModName());

        return atletas;
    }

    /**
     * @return da descrição do objecto
     */
    @Override
    public String toString() {
        return String.format("\nNome do clube: %s\n" + "Data de fundação: %s\n" + "Lista de Atletas: %s\n",
                nome, dataFundacao.getTime(), atletas);
    }

    public boolean isListaVazia() {
        return atletas.isEmpty();
    }

    public boolean addAtletaProfissional(String nome, int nic, int dia, int mes, int ano, String genero, String atividade, int FCR,int diaRegisto, int mesRegisto, int anoRegisto, double parcelaFixa){
        Profissional pro = new Profissional(nome, nic, dia, mes, ano, genero, atividade, FCR, diaRegisto, mesRegisto, anoRegisto, parcelaFixa);
        
        return addAtleta(pro);
    }
    
    public boolean addAtletaSemiProfissional(String nome, int nic, int dia, int mes, int ano, String genero, String atividade, int FCR,int diaRegisto, int mesRegisto, int anoRegisto){
        SemiProfissional semiPro = new SemiProfissional(nome, nic, dia, mes, ano, genero, atividade, FCR, diaRegisto, mesRegisto, anoRegisto);
        
        return addAtleta(semiPro);
    }
    
    public boolean addAtletaAmador(String nome, int nic, int dia, int mes, int ano, String genero, String atividade, int FCR,int diaRegisto, int mesRegisto, int anoRegisto){
        Amador amador = new Amador(nome, nic, dia, mes, ano, genero, atividade, FCR, diaRegisto, mesRegisto, anoRegisto);
        
        return addAtleta(amador);
    }
}
