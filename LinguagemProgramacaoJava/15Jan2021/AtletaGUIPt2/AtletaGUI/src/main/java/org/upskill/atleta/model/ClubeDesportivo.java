package org.upskill.atleta.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

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
    public ClubeDesportivo(){
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
        return atletas;
    }
    
    /**
     * método para adicionar atletas ao ArryList de Atletas
     * @param pessoa atleta que vai ser adicionada à lista de atletas do clube
     */
    public void addAtleta(Atleta pessoa) {
        atletas.add(pessoa);
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
     * @return atletas , lista de atletas por ordem decrescente do valor mensal arrecadado por atleta
     * de acordo com a classe ListOrdInversoValor que implementa a Interface Comparator
     */
    public ArrayList<Atleta> ListarOrdemInversaValor() {
        Collections.sort(atletas, new ListOrdInversoValor());

        return atletas;
    }
    
    /**
     * função que ordena uma lista segundo determinados parametros
     * 
     * @return atletas , lista de atletas ordenada por categoria, modalidade e nome
     * de acordo com a classe ListOrdCategModName que implementa a Interface Comparator
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
}
