/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empregado;

import com.mycompany.utilitarios.*;


/**
 *
 * @author joaor
 */
public class Empregado  {
    
    private String primeiroNome;
    private String ultimoNome;
    private Data dataContrato;
    private Tempo horaEntrada;
    private Tempo horaSaida;
    
    private static final String PRIMEIRO_OMISSO = "Sem Primeiro Nome";
    private static final String ULTIMO_OMISSO = "Sem Ultimo Nome";
    
    
    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato, Tempo horaEntrada, Tempo horaSaida){
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(dataContrato);
        this.horaEntrada = new Tempo(horaEntrada);
        this.horaSaida = new Tempo(horaSaida);
    }
    
    public Empregado(){
        this.primeiroNome = PRIMEIRO_OMISSO;
        this.ultimoNome = ULTIMO_OMISSO;
        this.dataContrato = new Data();
        this.horaEntrada = new Tempo();
        this.horaSaida = new Tempo();
    }


    /**
     * @return the primeiroNome
     */
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    /**
     * @param primeiroNome the primeiroNome to set
     */
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    /**
     * @return the ultimoNome
     */
    public String getUltimoNome() {
        return ultimoNome;
    }

    /**
     * @param ultimoNome the ultimoNome to set
     */
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    /**
     * @return the dataContrato
     */
    public Data getDataContrato() {
        return dataContrato;
    }

    /**
     * @param dataContrato the dataContrato to set
     */
    public void setDataContrato(Data dataContrato) {
        this.dataContrato = dataContrato;
    }

    /**
     * @return the horaEntrada
     */
    public Tempo getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @return the horaSaida
     */
    public Tempo getHoraSaida() {
        return horaSaida;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida = horaSaida;
    }
    
    public String toString(){
        return String.format("\nEmpregado\nPrimeiro Nome: %s\nUltimo Nome: %s\nEntrada : %s\nHora Entrada: %s\nHora Saida: %s\n",primeiroNome,ultimoNome,dataContrato,horaEntrada,horaSaida);
    }
    
    public int duracaoContrato(){
        return Data.dataAtual().diferenca(dataContrato);
    }
    
    public int horasTrabalho(){
        return (horaEntrada.diferencaEmSegundos(horaSaida) / 60) * 5;
    }
    
    
    
}
